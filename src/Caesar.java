import java.io.IOException;
import java.nio.file.Path;

public abstract class Caesar {
    private Path sourcePath;
    private Path outPath;
    private Key key;
    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }

    public void setKey(Key key) {
        this.key = key;
    }
    public abstract void run();
    public abstract void encode () throws IOException;
    public abstract void decode () throws IOException;
}

