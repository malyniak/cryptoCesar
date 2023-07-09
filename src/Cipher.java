public class Cipher extends Caesar {
    private static final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    public void encode() {
        this.writeText(cipheringText(readTextFromFile(this.getSourcePath())), this.getOutPath());
    }
    public String cipheringText(String text) {
        StringBuilder sb = new StringBuilder();
        char[] textChars = text.toCharArray();
        for (int i = 0; i < textChars.length; i++) {
            if (SYMBOLS.contains(text.substring(i, i + 1))) {
                int x = SYMBOLS.indexOf(text.substring(i, i + 1));
                if (x + getKey().getValue() >= SYMBOLS.length())
                    x = x - SYMBOLS.length();
                sb.append(SYMBOLS, x + getKey().getValue(), x + getKey().getValue() + 1);
                sb.append(getKey().addChars());
            } if(text.charAt(i) == '\n')
                sb.append("\n");
        }
        return sb.toString();
    }
}
