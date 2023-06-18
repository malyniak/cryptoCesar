import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    //   Brutforce brutforce=new BrutForce();
    Path srcPath;
    Path outPath;
    CesarFactory cesarFactory;
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
        System.out.println("Press path source file");
        String str = scanner.nextLine();
        Path path = Path.of(str);
        return path;
    }

    public Path getOutPath() {
        System.out.println("Press path out file");
        String str = scanner.nextLine();
        Path path = Path.of(str);
        return path;
    }

    public Key getKey() {
        System.out.println("Press key");
        return new Key(Integer.parseInt(scanner.nextLine()));
    }

}
