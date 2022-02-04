import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String fileJson = "";
        Document doc = null;
        List<PokeModel> pokeModelList = new ArrayList<>();
        try {
            doc = Jsoup.connect("https://dokhacchung98.github.io/policy/poke.html").get();


            Elements totalE = doc.getElementsByClass("pokemon-list");
            if (totalE.size() > 0) {
                Elements eFamily = totalE.get(0).getElementsByClass("family");

                for (Element family : eFamily) {

                    Elements gens = family.getElementsByClass("gen");
                    for (int i = 0; i < gens.size(); i++) {
                        Element gen = gens.get(i);
                        Elements pokemons = gen.getElementsByClass("pokemon");
                        for (Element e : pokemons) {
                            PokeModel pokeModel = new PokeModel();
                            if (e.getElementsByTag("h2").size() > 0) {
                                pokeModel.name = e.getElementsByTag("h2").first().text();
                            }
                            Elements ty = e.getElementsByTag("pokemon-tooltip");
                            for (Element t : ty) {
                                pokeModel.types.add(t.text());
                            }

                            if (e.getElementsByClass("id").size() > 0) {
                                pokeModel.id = Integer.parseInt(e.getElementsByClass("id").first().text());
                            }

                            if (e.getElementsByTag("img").size() > 0) {
                                pokeModel.linkImg = e.getElementsByTag("img").first().attr("src");
                            }
                            pokeModel.canUpdate = i < (pokemons.size() - 1);
                            if (i > 0) {
                                if (gens.get(i - 1).getElementsByClass("pokemon").size() > 0 && gens.get(i - 1).getElementsByClass("pokemon").first().getElementsByClass("id").size() > 0) {
                                    pokeModel.prePoke = Integer.parseInt(gens.get(i - 1).getElementsByClass("pokemon").first().getElementsByClass("id").first().text());
                                }
                            }
                            if (i < gens.size() - 1) {
                                Elements listNext = gens.get(i + 1).getElementsByClass("pokemon");
                                for (Element pokeN : listNext) {
                                    if (pokeN.getElementsByClass("id").size() > 0) {
                                        pokeModel.nextPoke.add(Integer.parseInt(pokeN.getElementsByClass("id").first().text()));
                                    }
                                }
                            }

                            if (e.getElementsByClass("bar").size() > 0) {
                                String str = e.getElementsByClass("bar").first().getElementsByClass("value").first().attr("style");
                                str = str.replaceAll("[^\\d.]", "");

                                pokeModel.setPower(Integer.parseInt(str.isEmpty() ? "0" : str.trim()), i, gens.size());

                            }

//                            saveImage(pokeModel.linkImg, pokeModel.id);
                            if (pokeModel.id != 0) {
                                pokeModelList.add(pokeModel);
                            }
                        }
                    }
                }

            }
            System.out.println("Title>>>>>>>>> : " + pokeModelList);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("EXC<<<<<<<< : " + e.getMessage());
        }
    }

    public static boolean aa = false;

    private static void saveImage(String path, int id) {
        try {
            if (path == null || path.isEmpty()) {
                return;
            }
            URL url = new URL(path);

            URLConnection uc = url.openConnection();
            uc.addRequestProperty("User-Agent",
                    "Mozilla/5.0");

            HttpURLConnection httpURLCon = (HttpURLConnection) url.openConnection();
            httpURLCon.addRequestProperty("User-Agent", "Mozilla/5.0");
            InputStream in = new BufferedInputStream(httpURLCon.getInputStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
//            out.close();
//            in.close();
            byte[] response = out.toByteArray();
            FileOutputStream fos = new FileOutputStream("//Users//dochung//Desktop//Project//IIIII//a" + id + ".png");
            fos.write(response);
            fos.close();
        } catch (IOException e) {
            // handle IOException
            e.printStackTrace();
        }
    }
}
