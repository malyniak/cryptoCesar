import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BruteForce extends Caesar {
    Key key = null;
    private Path sourcePath;

    private static final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    private Path outPath;

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }

    public ArrayList<String> readTextFromFile(Path path) {
        ArrayList<String> originalText = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while (bufferedReader.ready()) {
                originalText.add(bufferedReader.readLine());
            }
            return originalText;
        } catch (IOException e) {
            System.out.println("Invalid path");
        }
        return originalText;
    }

    public void writeText(String string, Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, Charset.defaultCharset())) {
                bufferedWriter.write(string);
        } catch (IOException e) {
            System.out.println("Invalid path");
        }
    }

    @Override
    public void decode() throws IOException {
        String textWithOutUselessSymb = findKey();
        String originalText = decipheringText(textWithOutUselessSymb);
        this.writeText(originalText, sourcePath);
    }

    public String decipheringText(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] charsOfLine = str.toCharArray();
        for (int i = 0; i < charsOfLine.length; i++) {
            if (SYMBOLS.contains(str.substring(i, i + 1))) {
                int x = SYMBOLS.indexOf(str.substring(i, i + 1));
                if (x - key.getValue() < 0) {
                    x = SYMBOLS.length() + x;
                }
                stringBuilder.append(SYMBOLS, x - key.getValue(), x - key.getValue() + 1);
            }
        }
        return stringBuilder.toString();
    }

    public String findKey() {
        String[] arr = null;
        Map<String, Key> keys = this.getKeys();
        ArrayList<String> strings = this.readTextFromFile(outPath);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s)
                    .append("\n");
        }
        String text = stringBuilder.toString();
        Set<String> spaces = keys.keySet();
        StringBuilder result = new StringBuilder();
        for (String s : spaces) {
            if (text.contains(s)) {
                key = keys.get(s);
                arr = text.split(s);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }


}
