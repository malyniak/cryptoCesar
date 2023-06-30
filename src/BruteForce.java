import java.util.*;
public class BruteForce extends Decipher {
    public Map<String, Key> getKeys() {
        Map<String, Key> mapKeys = new TreeMap<>();
        mapKeys.put("~~~", new KeyShift3(3));
        mapKeys.put("~~~~~", new KeyShift5(5));
        mapKeys.put("~~~~~~~~", new KeyShift8(8));
        return mapKeys;
    }
    @Override
    public void decode() {
       key = findKey();
        String originalText = decipheringText(this.readTextFromFile(outPath));
        this.writeText(originalText, sourcePath);
    }
    public Key findKey() {
        Map<String, Key> keys = this.getKeys();
       String text = this.readTextFromFile(outPath);
        Set<String> keySet = keys.keySet();
        for (String s : keySet) {
            if (text.contains(s))
                key = keys.get(s);
        }
        return key;
    }
    @Override
    public void initialize() {
        this.setSourcePath(menu.getSrcPath());
        this.setOutPath(menu.getOutPath());
    }


}
