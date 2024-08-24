import java.util.Random;

public class Entidade {
    public static class Jogador {
        private static String CharType;
        private static int Ataque = 0;
        private static int Defesa = 0;
        private static int Saude = 1;

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

        public static int getDefesa() {
            return Defesa;
        }

        public static void setDefesa(int defesa) {
            Defesa = defesa;
        }

        public static int getSaude() {
            return Saude;
        }

        public static void setSaude(int saude) {
            Saude = saude;
        }
    }
}
