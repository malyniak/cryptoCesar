public class KeyShift5Symbols extends Key {
    private final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    public KeyShift5Symbols(int value) {
        super(value);
    }
    public String encode(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] charsOfLine = s.toCharArray();
        for (int i = 0; i < charsOfLine.length; i++) {
            if (SYMBOLS.contains(s.substring(i, i + 1))) {
                int x = SYMBOLS.indexOf(s.substring(i, i + 1));
                if (x + this.getValue() >= SYMBOLS.length()) {
                    x = x - SYMBOLS.length();
                }
                stringBuilder.append(SYMBOLS, x + this.getValue(), x + this.getValue() + 1);

                stringBuilder.append("~~");
            }
        } return stringBuilder.toString();
    }
}
