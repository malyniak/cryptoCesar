import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private Caesar caesar;
    public static final String MENU_SELECT =
            """
                    Press 1 to encrypt/decrypt by key
                    Press 2 to select brute force method
                    Press 0 to exit
                    """;

    boolean isExit = false;

    public void start() throws IOException {

        System.out.println(MENU_SELECT);
        while (!isExit) {
            int menuNumber = Integer.parseInt(scanner.nextLine());
            switch (menuNumber) {
                case 1 -> {
                    caesar=new Cipher();
                }
                case 2 -> {
                }
                default -> System.out.println("");
            }
            if (caesar != null)
                isExit = true;
        }
        this.initialize(caesar);
       caesar.encode();
        caesar.decode();

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
    public void initialize (Caesar caesar) {
        caesar.setSourcePath(this.getSrcPath());
        caesar.setOutPath(this.getSrcPath());
        caesar.setKey(this.getKey());
    }

}

