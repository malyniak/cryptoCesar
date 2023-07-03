public class Decipher extends Caesar {
    private static final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    public void decode() {
        String ciphText = this.readTextFromFile(outPath);
        String resultText = this.decipheringText(ciphText);
        this.writeText(resultText, sourcePath);
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

