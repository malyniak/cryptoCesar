import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Виберіть режим роботи програми.\nДля вибору режиму шифрування/дешифрування введіть цифру %1$d\n" +
                          "Для вибору режиму \"brute force\" введіть цифру %2$d", 1, 2);
        int  optionOfWork;
        try(Scanner scanner=new Scanner(System.in)) {
            optionOfWork=scanner.nextInt();
            if(optionOfWork==1) {

            }


        }

    }

}