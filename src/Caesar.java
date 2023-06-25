import javax.xml.transform.Source;
import java.io.IOException;
import java.nio.file.Path;

public abstract class Caesar {
    Key key;
    Path sourcePath;
    Path outPath;
    public abstract void run();
    public abstract void encode () throws IOException;
    public abstract void decode () throws IOException;
}

