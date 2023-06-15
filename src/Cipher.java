import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Cipher {
    private Path sourcePath;
    private final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГГДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    private Path outPath;
    private Key key;
    private ArrayList<String> originalText;


    public Cipher(Path sourcePath, Key key) {
        this.sourcePath = sourcePath;
        this.key = key;
    }

    public ArrayList<String> readTextFromFile() {
        ArrayList<String> originalText = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(sourcePath)) {
            while (bufferedReader.ready()) {
                originalText.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Файл" + sourcePath.toString() + " не знайдено. Попробуйте ще раз.");
        }
        return originalText;
    }

    public ArrayList<String> cipheringText(ArrayList<String> strings) {
        ArrayList<String> changedList = new ArrayList<>();
        for (String s : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] charsOfLine = s.toCharArray();
            for (int i = 0; i < charsOfLine.length; i++) {
                if (SYMBOLS.contains(s.substring(i, i + 1))) {
                   int x= SYMBOLS.indexOf(s.substring(i, i+1));
                    stringBuilder.append(SYMBOLS.substring(x+key.getValue(), x+ key.getValue()+1));
                }
            }
            changedList.add(stringBuilder.toString());
        }
        return changedList;
    }

}
