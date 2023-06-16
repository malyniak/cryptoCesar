import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Виберіть режим роботи програми.\nДля вибору режиму шифрування/дешифрування введіть цифру %1$d\n" +
                          "Для вибору режиму brute force введіть цифру %\n", 1, 2);
        int  optionOfWork;
        try(Scanner scanner=new Scanner(System.in)) {
            optionOfWork=scanner.nextInt();
            if(optionOfWork==1) {
            int value= (int) (Math.random() * 8) +2;
            Key key=new Key(value);
            System.out.println("Введіть шлях текстовго файлу");
            Cipher cipher=new Cipher(Path.of(scanner.nextLine()), key);
            cipher.readTextFromFile();

            }


        }

    }

}