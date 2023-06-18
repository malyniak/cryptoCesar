import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        CesarFactory cesarFactory = menu.start();
        cesarFactory.initialize(menu);
        cesarFactory.encode();
        cesarFactory.decode();
    }
}

