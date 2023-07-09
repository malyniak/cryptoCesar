import java.util.*;
public class BruteForce extends Decipher {
    public Map<String, Key> getKeys() {
        Map<String, Key> mapKeys = new TreeMap<>();
        mapKeys.put("~~~", new KeyShift3());
        mapKeys.put("~~~~~", new KeyShift5());
        mapKeys.put("~~~~~~~~", new KeyShift8());
        return mapKeys;
    }
    @Override
    public void decode() {
        this.setKey(findKey());
        String originalText = decipheringText(this.readTextFromFile(this.getOutPath()));
        this.writeText(originalText, this.getOutPath());
    }
    public Key findKey() {
        Key key=null;
        Map<String, Key> keys = this.getKeys();
       String text = this.readTextFromFile(this.getOutPath());
        Set<String> keySet = keys.keySet();
        for (String s : keySet) {
            if (text.contains(s))
                key = keys.get(s);
        }
        return key;
    }
    @Override
    public void initialize() {
        this.setSourcePath(new Menu().getSrcPath());
        this.setOutPath(new Menu().getOutPath());
    }
}
