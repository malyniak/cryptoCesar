public class Cipher extends Caesar {
    private static final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    public void encode() {
        this.writeText(cipheringText(readTextFromFile(sourcePath)), outPath);
    }
    public String cipheringText(String text) {
        StringBuilder sb = new StringBuilder();
        char[] textChars = text.toCharArray();
        for (int i = 0; i < textChars.length; i++) {
            if (SYMBOLS.contains(text.substring(i, i + 1))) {
                int x = SYMBOLS.indexOf(text.substring(i, i + 1));
                if (x + key.getValue() >= SYMBOLS.length())
                    x = x - SYMBOLS.length();
                sb.append(SYMBOLS, x + key.getValue(), x + key.getValue() + 1);
                sb.append(key.addChars());
            } if(text.charAt(i) == '\n')
                sb.append("\n");
        }
        return sb.toString();
    }
}
