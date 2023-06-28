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
    private static final int Menu_EXIT = 0;
    private static final int Menu_ITEM0 = 1;
    private static final int Menu_ITEM1 = 2;
    private static final int Menu_ITEM2 = 3;


    Scanner scanner = new Scanner(System.in);
    private Caesar caesar;

    boolean isExit = false;

    public void start() throws IOException {

        System.out.println(MENU_SELECT);
        while (!isExit) {
            int menuNumber = Integer.parseInt(scanner.nextLine());
            switch (menuNumber) {
                case Menu_ITEM0 -> {
                    caesar=new Cipher();
                    this.initialize();
                    caesar.setKey(this.getKey());
                    caesar.encode();
                }

                case Menu_ITEM1 -> {
                    caesar = new Cipher();
                    this.initialize();
                    caesar.setKey(this.getKey());
                    caesar.decode();
                }
                case Menu_ITEM2 -> {
                    caesar=new BruteForce();
                    this.initialize();
                    caesar.decode();

                }
                case Menu_EXIT -> {
                    isExit = true;
                }
                default -> System.out.println("Invalid option. Try again");
            }
            if (caesar != null)
                isExit = true;
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
        System.out.println("Press key");
        return new Key(Integer.parseInt(scanner.nextLine()));
    }

    public void initialize() {
        caesar.setSourcePath(this.getSrcPath());
        caesar.setOutPath(this.getOutPath());
    }


}

