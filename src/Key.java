public class Key {
    private final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
   private int value;


    public int getValue() {
        return value;
    }
    public Key (int value) {
        this.value=value;
    }
    public String encode(String s) {
        return null;
    }

}
