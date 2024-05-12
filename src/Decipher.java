public class Decipher extends Caesar {
    public void decode() {
        String ciphText = this.readTextFromFile(this.getOutPath());
        String resultText = this.decipheringText(ciphText);
        this.writeText(resultText, this.getSourcePath());
    }
    public String decipheringText(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = text.toCharArray();
        for (char symbol : charArray) {
            if (!Character.toString(symbol).contains("~")) {
                char changedSymbol = (char) ((int) symbol - getKey().getValue());
                stringBuilder.append(changedSymbol);
            }
        }
        return stringBuilder.toString();
    }
}

