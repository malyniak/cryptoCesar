import java.nio.file.Path;
import java.util.Scanner;
public class Menu {
    private static final String MENU_SELECT =
            """
                    Press 1 to encrypt by key
                    Press 2 to decrypt by key
                    Press 3 to select brute force method
                    Press 0 to exit
                    """;
    private static final String KEY_SELECT =
            """
                    Press 3 to move symbols on 3
                    Press 5 to move symbols on 5
                    Press 8 to move symbols on 8
                    """;
    private static final int MENU_EXIT = 0;
    private static final int MENU_ITEM0 = 1;
    private static final int MENU_ITEM1 = 2;
    private static final int MENU_ITEM2 = 3;
    private static final int Key_SHIFT3=3;
    private static final int Key_SHIFT5=5;
    private static final int Key_SHIFT8=8;
    Scanner scanner = new Scanner(System.in);
    private Decipher decipher;
    private Cipher cipher;
    boolean isExit = false;

    public void start() {
        System.out.println(MENU_SELECT);
        while (!isExit) {
            int menuNumber = Integer.parseInt(scanner.nextLine());
            switch (menuNumber) {
                case MENU_ITEM0 -> {
                    cipher = new Cipher();
                    cipher.initialize();
                    cipher.encode();
                }
                case MENU_ITEM1 -> {
                    decipher = new Decipher();
                    decipher.initialize();
                    decipher.decode();
                }
                case MENU_ITEM2 -> {
                    decipher = new BruteForce();
                    decipher.initialize();
                    decipher.decode();
                }
                case MENU_EXIT ->
                    isExit = true;
                default -> System.out.println("Invalid option. Try again");
            } if(decipher!=null || cipher!=null)
                isExit=true;
        }
    }
    public Path getSrcPath() {
        System.out.println("Press path of source file");
        return Path.of(scanner.nextLine());
    }
    public Path getOutPath() {
        System.out.println("Press path of out file");
        return Path.of(scanner.nextLine());
    }
    public Key getKey() {
        System.out.println(KEY_SELECT);
        int k=Integer.parseInt(scanner.nextLine());
        switch (k) {
            case Key_SHIFT3 -> {
                return new KeyShift3();
            }
            case Key_SHIFT5 ->
            {
                return new KeyShift5();
            }
            case Key_SHIFT8 -> {
                return new KeyShift8();
            }
        } throw new RuntimeException("Invalid Key");
    }
}

