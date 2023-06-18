import java.io.IOException;

public class CesarFactory {
   static int x;
   static CesarFactory cesarFactory=createCesar(x);
    public static CesarFactory createCesar(int x) {
        cesarFactory=null;
        switch (x) {
            case 1 : cesarFactory= new Cipher();
            break;
            case 2 : return null;
            default: System.out.println("");
        } return cesarFactory;
    }
    public void initialize (Menu menu) {}
    public void encode () throws IOException {}
    public void decode () throws IOException {}
}
