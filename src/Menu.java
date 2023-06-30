import java.io.IOException;
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
                    Press 3 to select Key3
                    Press 5 to select Key5
                    Press 8 to select Key8
                    """;
    private static final int MENU_EXIT = 0;
    private static final int MENU_ITEM0 = 1;
    private static final int MENU_ITEM1 = 2;
    private static final int MENU_ITEM2 = 3;

    private static final int KEY3=3;
    private static final int KEY5=5;
    private static final int KEY8=8;
    Scanner scanner = new Scanner(System.in);
    private Caesar caesar;
    boolean isExit = false;

    public void start() throws IOException {

        System.out.println(MENU_SELECT);
        while (!isExit) {
            int menuNumber = Integer.parseInt(scanner.nextLine());
            switch (menuNumber) {
                case MENU_ITEM0 -> {
                    caesar = new Cipher();
                    this.initialize();
                    caesar.encode();
                }

                case MENU_ITEM1 -> {
                    caesar = new Cipher();
                    this.initialize();
                    caesar.decode();
                }
                case MENU_ITEM2 -> {
                    caesar = new BruteForce();
                    this.initialize();
                    caesar.decode();

                }
                case MENU_EXIT -> {
                    isExit = true;
                }
                default -> System.out.println("Invalid option. Try again");
            } if(caesar!=null)
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
            case KEY3 -> {

            return new KeyShift3(3);
            }
            case KEY5 ->
            {
                return new KeyShift5(5);
            }
            case KEY8 -> {
                return new KeyShift8(8);
            }
        } throw new RuntimeException("Invalid Key");
    }

    public void initialize() {
        caesar.setSourcePath(this.getSrcPath());
        caesar.setOutPath(this.getOutPath());
        if(caesar instanceof Cipher) {
            caesar.setKey(this.getKey());
        }
    }


}

