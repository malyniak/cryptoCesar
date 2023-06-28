import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public abstract class Caesar {
    private Key key;
    private Path sourcePath;
    private Path outPath;
    Key key1 = new KeyShift3Symbols(3);
    Key key2 = new KeyShift5Symbols(5);
    Key key3 = new KeyShift8Symbols(8);

    public void setKey(Key key) {
        this.key = key;
    }

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }

    public Map<String, Key> getKeys() {
        Map<String, Key> mapKeys = new TreeMap<>();
        mapKeys.put("~~~", key1);
        mapKeys.put("~~~~~", key2);
        mapKeys.put("~~~~~~~~", key3);
        return mapKeys;
    }

    public abstract void decode() throws IOException;

    public void encode() {
    }
}

