public class Decipher extends Caesar {
    private static final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    public void decode() {
        String ciphText = this.readTextFromFile(this.getOutPath());
        String resultText = this.decipheringText(ciphText);
        this.writeText(resultText, this.getSourcePath());
    }
    public String decipheringText(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charsOfText = str.toCharArray();
        for (int i = 0; i < charsOfText.length; i++) {
            if (SYMBOLS.contains(str.substring(i, i + 1))) {
                int x = SYMBOLS.indexOf(str.substring(i, i + 1));
                if (x - this.getKey().getValue() < 0) {
                    x = SYMBOLS.length() + x;
                }
                sb.append(SYMBOLS, x - this.getKey().getValue(), x - this.getKey().getValue() + 1);
            }
            if(str.charAt(i) == '\n')
                sb.append("\n");
        }
        return sb.toString();
    }
}

