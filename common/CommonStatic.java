package common;

public class CommonStatic {
    /* * TBC Modder 1.0
     * Core configuration and version compatibility 
     */
    
    // Default Battle Cats version for the modder
    public static String BC_VERSION = "15.2";
    
    // Supported Locales: EN, JP, KR, TW
    public static String GAME_LANG = "EN";

    public static void main(String[] args) {
        System.out.println("TBC Modder 1.0 - Core Engine Ready");
        System.out.println("Target BC Version: " + BC_VERSION);
    }
}
