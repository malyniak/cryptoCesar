public class Cipher extends Caesar {
    public void encode() {
        this.writeText(cipheringText(readTextFromFile(this.getSourcePath())), this.getOutPath());
    }
    public String cipheringText(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = text.toCharArray();
        for (char symbol : charArray) {
            char changedSymbol = (char) ((int) symbol + getKey().getValue());
            stringBuilder.append(changedSymbol);
        }
        stringBuilder.append(getKey().addChars());
        return stringBuilder.toString();
    }
}

