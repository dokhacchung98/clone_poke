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

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
//                ", \"linkImg\":\"" + linkImg + '\"' +
                ", \"types\":" + types +
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
