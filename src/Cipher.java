
import java.nio.file.Path;

public class Cipher extends Caesar {

    private static final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    private Path sourcePath;
    private Path outPath;
    private Key key;

    public void setKey(Key key) {
        this.key = key;
    }

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }

    public void encode() {
        this.writeText(cipheringText(readTextFromFile(sourcePath)), outPath);
    }

    public void decode() {
        String strings = this.readTextFromFile(outPath);
       String strings1 = this.decipheringText(strings.toString());
        this.writeText(strings1, sourcePath);
    }
    public String cipheringText(String strings) {
        StringBuilder stringBuilder = new StringBuilder();
            char[] charsOfLine = strings.toCharArray();
            for (int i = 0; i < charsOfLine.length; i++) {
                if (SYMBOLS.contains(strings.substring(i, i + 1))) {
                    int x = SYMBOLS.indexOf(strings.substring(i, i + 1));
                    if (x + key.getValue() >= SYMBOLS.length()) {
                        x = x - SYMBOLS.length();
                    }
                    stringBuilder.append(SYMBOLS, x + key.getValue(), x + key.getValue() + 1);
                        stringBuilder.append(key.addChars());

                } if(strings.substring(i, i+1).equals("\n"))
                    stringBuilder.append("\n");
            }
        return stringBuilder.toString();
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
            } if(str.substring(i, i+1).equals(" "))
                stringBuilder.append(" ");
            if(str.substring(i, i+1).equals("\n"))
                stringBuilder.append("\n");
        } stringBuilder.append(key.addChars());
        return stringBuilder.toString();
    }

}