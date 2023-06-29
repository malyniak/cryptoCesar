import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class BruteForce extends Caesar {
    Key key;
    private Path sourcePath;

    private static final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    private Path outPath;

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }

    @Override
    public void decode() throws IOException {
       key = findKey();
        String originalText = decipheringText(this.readTextFromFile(outPath).toString());
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
            } if(str.substring(i, i+1).equals("\n"))
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Key findKey() {
        Map<String, Key> keys = this.getKeys();
       String listStringsFromSrcFile = this.readTextFromFile(outPath);
        Set<String> keySet = keys.keySet();
        for (String s : keySet) {
            if (listStringsFromSrcFile.contains(s)) {
                key = keys.get(s);
            }
        }
        return key;
    }


}
