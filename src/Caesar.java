import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public abstract class Caesar {
    private Key key;
    private Path sourcePath;
    private Path outPath;

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
        mapKeys.put("~~~", new KeyShift3(3));
        mapKeys.put("~~~~~", new KeyShift5(5));
        mapKeys.put("~~~~~~~~", new KeyShift8(8));
        return mapKeys;
    }

    public abstract void decode() throws IOException;
    public String readTextFromFile(Path path) {
      StringBuilder originalText  = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while (bufferedReader.ready()) {
                originalText.append(bufferedReader.readLine()).append("\n");
            }
            return originalText.toString();
        } catch (IOException e) {
            System.out.println("Invalid path");
        }
        return null;
    }
    public void writeText(String string, Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            bufferedWriter.write(string);
        } catch (IOException e) {
            System.out.println("Invalid path");
        }
    }
    public void encode() {
    }
}

