
import java.nio.file.Path;

public class CipherDecipherByKey extends Caesar {

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
        String ciphText = this.readTextFromFile(outPath);
        String resultText = this.decipheringText(ciphText);
        this.writeText(resultText, sourcePath);
    }
    public String cipheringText(String text) {
        StringBuilder sb = new StringBuilder();
            char[] textChars = text.toCharArray();
            for (int i = 0; i < textChars.length; i++) {
                if (SYMBOLS.contains(text.substring(i, i + 1))) {
                    int x = SYMBOLS.indexOf(text.substring(i, i + 1));
                    if (x + key.getValue() >= SYMBOLS.length()) {
                        x = x - SYMBOLS.length();
                    }
                    sb.append(SYMBOLS, x + key.getValue(), x + key.getValue() + 1);
                        sb.append(key.addChars());

                } if(text.charAt(i) == '\n')
                    sb.append("\n");
            }
        return sb.toString();
    }
    public String decipheringText(String str) {

        StringBuilder sb = new StringBuilder();
        char[] charsOfText = str.toCharArray();
        for (int i = 0; i < charsOfText.length; i++) {
            if (SYMBOLS.contains(str.substring(i, i + 1))) {
                int x = SYMBOLS.indexOf(str.substring(i, i + 1));
                if (x - key.getValue() < 0) {
                    x = SYMBOLS.length() + x;
                }
                sb.append(SYMBOLS, x - key.getValue(), x - key.getValue() + 1);
            }
            if(str.charAt(i) == '\n')
                sb.append("\n");
        }
        return sb.toString();
    }

}