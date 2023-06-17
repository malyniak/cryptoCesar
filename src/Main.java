import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu=new Menu();
        Cipher cipher = menu.start();
        cipher.initialize(menu);
        cipher.writeText(cipher.cipheringText(cipher.readTextFromFile()));
            }
        }

