import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private CesarFactory cesarFactory;
    public static final String MENU_SELECT =
            """
                    Press 1 to encrypt/decrypt by key
                    Press 2 to select brute force method
                    Press 0 to exit
                    """;

    boolean isExit = false;

    public CesarFactory start() {

        System.out.println(MENU_SELECT);
        while (!isExit) {
            int menuNumber = Integer.parseInt(scanner.nextLine());
            cesarFactory = CesarFactory.createCesar(menuNumber);
            if (cesarFactory != null)
                isExit = true;
        }
        return cesarFactory;
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

}

