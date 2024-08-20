public class Entidade {
    public static class Jogador {
        private static String CharType;
        private static int Ataque = 0;

        public static String getCharType() {
            return CharType;
        }

        public static void setCharType(String charType) {
            CharType = charType;
        }

        public static int getAtaque() {
            return Ataque;
        }

        public static void setAtaque(int ataque) {
            Ataque = ataque;
        }
    }
}
