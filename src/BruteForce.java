import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BruteForce extends Caesar {
    private Path sourcePath;

    private final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    private Path outPath;


    @Override
    public void run() {

    }
    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }
    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }
    @Override
    public void encode() {
        this.writeText(cipheringText(readTextFromFile(sourcePath)), outPath);
    }
    public ArrayList<String> readTextFromFile(Path path) {
        ArrayList<String> originalText = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while (bufferedReader.ready()) {
                originalText.add(bufferedReader.readLine());
            }
            return originalText;
        } catch (IOException e) {
            System.out.println("Invalid path");
        } return originalText;
    }
    public void writeText(ArrayList<String> list, Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            for (String line : list) {
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            System.out.println("Invalid path");
        }
    }

    public ArrayList<String> cipheringText(ArrayList<String> strings) {
        ArrayList<String> changedList = new ArrayList<>();
        for (String s : strings) {
            String line = key2.encode(s);
            changedList.add(line);
        }
        return changedList;
    }


    @Override
    public void decode() throws IOException {
        Key key=null;
        String[] arr=null;
        Map<String, Key> keys = this.getKeys();
        ArrayList<String> strings = this.readTextFromFile(outPath);
        StringBuilder stringBuilder=new StringBuilder();
        for(String s : strings) {
            stringBuilder.append(s)
                    .append("\n");
        }
        String text=stringBuilder.toString();
        Set<String> spaces = keys.keySet();
        StringBuilder result=new StringBuilder();
        for(String s: spaces) {
            if(text.contains(s)) {
                key=keys.get(s);
               arr=text.split(s);
            }
        }
        for(int i=0; i< arr.length; i++) {
            result.append(arr[i]);
        }
        StringBuilder ost=new StringBuilder();
        char[] charsOfLine = result.toString().toCharArray();
        for (int i = 0; i < charsOfLine.length; i++) {
            if (SYMBOLS.contains(result.toString().substring(i, i + 1))) {
                int x = SYMBOLS.indexOf(result.toString().substring(i, i + 1));
                if (x - key.getValue() < 0) {
                    x = SYMBOLS.length() + x ;
                }
                ost.append(SYMBOLS, x - key.getValue(), x - key.getValue() + 1);

            }
        }
        this.writeText(new ArrayList<>(List.of(ost.toString().split("\n"))), sourcePath);


    }

}
