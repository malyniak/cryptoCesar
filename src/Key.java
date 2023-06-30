public class Key {
    private int value;
    public int getValue() {
        return value;
    }

    public Key(int value) {
        this.value = value;
    }
    public String addChars() {
        int count=0;
        StringBuilder sb=new StringBuilder();
        while (count++<value)
            sb.append("~");
        return sb.toString();
    }
}
