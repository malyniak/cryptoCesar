import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Виберіть режим роботи програми.\nДля вибору режиму шифрування/дешифрування введіть цифру %1$d\n" +
                "Для вибору режиму brute force введіть цифру %2$d\n", 1, 2);
        int optionOfWork;
        try (Scanner scanner = new Scanner(System.in)) {
            optionOfWork = Integer.parseInt(scanner.nextLine());
            if (optionOfWork == 1) {
                System.out.println("Введіть ключ для шиифрування більше 1");
                int value;
                while ((value=Integer.parseInt(scanner.nextLine()))<=1) {
                    System.out.println("Ви ввели неправильний значення. Попробуйте ще раз.");
                }
                System.out.println("Введіть шлях оригінального текстовго файлу");
                Cipher cipher = new Cipher(Path.of(scanner.nextLine()), new Key(value));
                ArrayList<String> text = cipher.readTextFromFile();
                System.out.println("Введіть шлях для збереження зашифрованого текстовго файлу");
                cipher.setOutPath(Path.of(scanner.nextLine()));
                scanner.close();
                cipher.writeText(cipher.cipheringText(text));
            }
        }
    }
}