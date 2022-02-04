public class RariryConstant {

    public enum EnumTypeRarity {
        TYPE_B(0, 92, 86, 88, 7),
        TYPE_A(1, 111, 97, 101, 11),
        TYPE_S(2, 134, 106, 113, 14),
        TYPE_SS(3, 152, 118, 125, 17),
        TYPE_SSS(4, 176, 131, 143, 22);

        private int type;
        private int dame;
        private int hp;
        private int defense;
        private int trueDame;

        public int getType() {
            return type;
        }

        public int getDame() {
            return dame;
        }

        public int getHp() {
            return hp;
        }

        public int getDefense() {
            return defense;
        }

        public int getTrueDame() {
            return trueDame;
        }

        EnumTypeRarity(int type, int hp, int defense, int dame, int trueDame) {
            this.type = type;
            this.dame = dame;
            this.hp = hp;
            this.defense = defense;
            this.trueDame = trueDame;
        }
    }
}
