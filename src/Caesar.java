import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
public abstract class Caesar {
    Key key;
    Path sourcePath;
    Path outPath;
    Menu menu;

    public void setKey(Key key) {
        this.key = key;
    }

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }

    public void initialize() {
        menu = new Menu();
        this.setSourcePath(menu.getSrcPath());
        this.setOutPath(menu.getOutPath());
        this.setKey(menu.getKey());
    }

    public String readTextFromFile(Path path) {
        StringBuilder originalText = new StringBuilder();
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
}

