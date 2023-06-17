import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    Scanner scanner=new Scanner(System.in);
    //   Brutforce brutforce=new BrutForce();
    Path srcPath;
    Path outPath;
    public static final String MENU_SELECT =
            """
                    Press 1 to encrypt/decrypt by key
                    Press 2 to select brute force method
                    Press 0 to exit
                    """;

    boolean isExit = false;

    public Cipher start() {
        Cipher cipher=null;
        System.out.println(MENU_SELECT);
        while (!isExit) {
            int menuNumber = Integer.parseInt(scanner.nextLine());
            switch (menuNumber) {
                case 0:
                    isExit = true;

                    break;
                case 1:
                    cipher=new Cipher();
                    isExit = true;
                    break;
                case 2:
                    isExit = true;
                    break;
                default:
                    throw new RuntimeException("Incorrect number.");
            }

        } return cipher;
    } public Path getSrcPath () {
        System.out.println("Press path source file");
        String str= scanner.nextLine();
        Path path=Path.of(str);
        return path;
    }
    public Path getOutPath () {
        System.out.println("Press path out file");
        String str = scanner.nextLine();
        Path path = Path.of(str);
        return path;
    }
    public Key getKey () {
        System.out.println("Press key");
        return new Key(Integer.parseInt(scanner.nextLine()));
    }

}

