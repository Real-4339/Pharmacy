package fiit.Lekaren.Colours;

public class Colours {

         static String ANSI_RESET;
         static String ANSI_BLACK;
         static String ANSI_RED;
         static String ANSI_GREEN;
         static String ANSI_YELLOW;
         static String ANSI_BLUE;
         static String ANSI_PURPLE;
         static String ANSI_CYAN;
         static String ANSI_WHITE;

        private static Colours Instance;

        public static Colours getInstance() {
                if (Instance == null){
                        Instance = new Colours();
                }
                return Instance;
        }

        private Colours(){
        ANSI_RESET = "\u001B[0m";
        ANSI_BLACK = "\u001B[30m";
        ANSI_RED = "\u001B[31m";
        ANSI_GREEN = "\u001B[32m";
        ANSI_YELLOW = "\u001B[33m";
        ANSI_BLUE = "\u001B[34m";
        ANSI_PURPLE = "\u001B[35m";
        ANSI_CYAN = "\u001B[36m";
        ANSI_WHITE = "\u001B[37m";
        }

        public String getAnsiReset() {
                return ANSI_RESET;
        }

        public String getANSI_BLACK() {
                return ANSI_BLACK;
        }

        public String getANSI_RED() {
                return ANSI_RED;
        }

        public String getANSI_GREEN() {
                return ANSI_GREEN;
        }

        public String getANSI_YELLOW() {
                return ANSI_YELLOW;
        }

        public String getANSI_BLUE() {
                return ANSI_BLUE;
        }

        public String getANSI_PURPLE() {
                return ANSI_PURPLE;
        }

        public String getANSI_CYAN() {
                return ANSI_CYAN;
        }

        public String getANSI_WHITE() {
                return ANSI_WHITE;
        }
}
