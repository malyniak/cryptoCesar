import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Cipher {
    Path sourcePath;
    Path outFile;
    BufferedReader bufferedReader;
    Key key;

    public Cipher (Path sourcePath, Key key) {
        this.sourcePath=sourcePath;
        this.key=key;
    }
    public ArrayList<String> textFromFile (Path path) {
        ArrayList<String> text=new ArrayList<>();
        try(BufferedReader bufferedReader=Files.newBufferedReader(path);
            BufferedWriter bufferedWriter=Files.newBufferedWriter(path, Charset.defaultCharset())) {


    }
        catch (IOException e) {
                System.out.println("Файл"+path.toString()+" не знайдено. Попробуйте ще раз.");
        }
        return text;
        }
}
