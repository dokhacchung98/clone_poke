import java.util.ArrayList;

public class PokeModel {
    public int id;
    public String name;
    public String linkImg;
    public ArrayList<String> types = new ArrayList<>();
    public boolean canUpdate = false;
    public ArrayList<Integer> nextPoke = new ArrayList<>();
    public int prePoke = -1;
    public RariryConstant.EnumTypeRarity rarity = RariryConstant.EnumTypeRarity.TYPE_A;

    public int power = 0;
    public int baseHp = 0;
    public int baseDefense = 0;
    public int baseDame = 0;

    public void setPower(int v, int level, int totalLevel) {
        float ratio = 1;
        if (totalLevel == 3) {
            if (level == 2) {
                ratio = 1;
                if (v < 45) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_A;
                } else if (v < 65) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_A;
                } else if (v < 75) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_S;
                } else if (v < 85) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SS;
                } else {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SSS;
                }
            } else if (level == 1) {
                ratio = 0.9f;
                if (v < 35) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_B;
                } else if (v < 55) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_A;
                } else if (v < 65) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_S;
                } else if (v < 75) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SS;
                } else {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SSS;
                }
            } else {
                ratio = 0.8f;
                if (v < 20) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_B;
                } else if (v < 40) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_A;
                } else if (v < 50) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_S;
                } else if (v < 60) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SS;
                } else {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SSS;
                }
            }
        } else if (totalLevel == 2) {
            if (level == 1) {
                ratio = 1;
                if (v < 42) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_B;
                } else if (v < 62) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_A;
                } else if (v < 72) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_S;
                } else if (v < 82) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SS;
                } else {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SSS;
                }
            } else {
                ratio = 0.9f;
                if (v < 30) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_B;
                } else if (v < 50) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_A;
                } else if (v < 60) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_S;
                } else if (v < 70) {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SS;
                } else {
                    rarity = RariryConstant.EnumTypeRarity.TYPE_SSS;
                }
            }
        } else {
            ratio = 1;
            if (v < 40) {
                rarity = RariryConstant.EnumTypeRarity.TYPE_B;
            } else if (v < 60) {
                rarity = RariryConstant.EnumTypeRarity.TYPE_A;
            } else if (v < 70) {
                rarity = RariryConstant.EnumTypeRarity.TYPE_S;
            } else if (v < 80) {
                rarity = RariryConstant.EnumTypeRarity.TYPE_SS;
            } else {
                rarity = RariryConstant.EnumTypeRarity.TYPE_SSS;
            }
        }
        baseHp = (int) (rarity.getHp() * ratio);
        baseDefense = (int) (rarity.getDefense() * ratio);
        baseDame = (int) (ratio * rarity.getTrueDame());
        power = (int) (ratio * rarity.getDame());
    }


//    <a href="#normal" class="type POKEMON_TYPE_NORMAL pokemon-tooltip" data-type="1">Normal</a>
//    <a href="#fighting" class="type POKEMON_TYPE_FIGHTING pokemon-tooltip" data-type="2">Fighting</a>
//    <a href="#flying" class="type POKEMON_TYPE_FLYING pokemon-tooltip" data-type="3">Flying</a>
//    <a href="#poison" class="type POKEMON_TYPE_POISON pokemon-tooltip" data-type="4">Poison</a>
//    <a href="#ground" class="type POKEMON_TYPE_GROUND pokemon-tooltip" data-type="5">Ground</a>
//    <a href="#rock" class="type POKEMON_TYPE_ROCK pokemon-tooltip" data-type="6">Rock</a>
//    <a href="#bug" class="type POKEMON_TYPE_BUG pokemon-tooltip" data-type="7">Bug</a>
//    <a href="#ghost" class="type POKEMON_TYPE_GHOST pokemon-tooltip" data-type="8">Ghost</a>
//    <a href="#steel" class="type POKEMON_TYPE_STEEL pokemon-tooltip" data-type="9">Steel</a>
//    <a href="#fire" class="type POKEMON_TYPE_FIRE pokemon-tooltip" data-type="10">Fire</a>
//    <a href="#water" class="type POKEMON_TYPE_WATER pokemon-tooltip" data-type="11">Water</a>
//    <a href="#grass" class="type POKEMON_TYPE_GRASS pokemon-tooltip" data-type="12">Grass</a>
//    <a href="#electric" class="type POKEMON_TYPE_ELECTRIC pokemon-tooltip" data-type="13">Electric</a>
//    <a href="#psychic" class="type POKEMON_TYPE_PSYCHIC pokemon-tooltip" data-type="14">Psychic</a>
//    <a href="#ice" class="type POKEMON_TYPE_ICE pokemon-tooltip" data-type="15">Ice</a>
//    <a href="#dragon" class="type POKEMON_TYPE_DRAGON pokemon-tooltip" data-type="16">Dragon</a>
//    <a href="#dark" class="type POKEMON_TYPE_DARK pokemon-tooltip" data-type="17">Dark</a>
//    <a href="#fairy" class="type POKEMON_TYPE_FAIRY pokemon-tooltip" data-type="18">Fairy</a>

    @Override
    public String toString() {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (String t : types) {
            int k = 0;
            switch (t) {
                case "Fire":
                    k = 0;
                    break;
                case "Water":
                    k = 1;
                    break;
                case "Grass":
                    k = 2;
                    break;
                case "Electric":
                    k = 3;
                    break;
                case "Psychic":
                    k = 4;
                    break;
                case "Steel":
                    k = 5;
                    break;
                case "Ice":
                    k = 6;
                    break;
                case "Dragon":
                    k = 7;
                    break;
                case "Dark":
                    k = 8;
                    break;
                case "Fairy":
                    k = 9;
                    break;
                case "Flying":
                    k = 10;
                    break;
                case "Poison":
                    k = 11;
                    break;
                case "Ground":
                    k = 12;
                    break;
                case "Rock":
                    k = 13;
                    break;
                case "Bug":
                    k = 14;
                    break;
                case "Ghost":
                    k = 15;
                    break;
                case "Normal":
                    k = 16;
                    break;
                case "Fighting":
                    k = 17;
                    break;
            }
            tmp.add(k);
        }
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
//                ", \"linkImg\":\"" + linkImg + '\"' +
                ", \"types\":" + tmp +
                ", \"canUpdate\":" + canUpdate +
                ", \"nextPoke\":" + nextPoke +
                ", \"prePoke\":" + prePoke +
                ", \"power\":" + power +
                ", \"baseHp\":" + baseHp +
                ", \"baseDefense\":" + baseDefense +
                ", \"baseDame\":" + baseDame +
                '}';
    }
}
