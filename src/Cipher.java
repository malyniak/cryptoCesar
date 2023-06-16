import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class Cipher {
    private Path sourcePath;
    private final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГГДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";

    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }

    private Path outPath;
    private Key key;

    public ArrayList<String> getOriginalText() {
        return originalText;
    }

    public void setOriginalText(ArrayList<String> originalText) {
        this.originalText = originalText;
    }

    private ArrayList<String> originalText;


    public Cipher(Path sourcePath, Key key) {
        this.sourcePath = sourcePath;
        this.key = key;
    }

    public ArrayList<String> readTextFromFile() {
        ArrayList<String> originalText = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(this.sourcePath)) {
            while (bufferedReader.ready()) {
                originalText.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Файл" + sourcePath.toString() + " не знайдено. Попробуйте ще раз.");
        }
        return originalText;
    }

    public ArrayList<String> cipheringText(ArrayList<String> strings) {
        ArrayList<String> changedList = new ArrayList<>();
        for (String s : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] charsOfLine = s.toCharArray();
            for (int i = 0; i < charsOfLine.length; i++) {
                if (SYMBOLS.contains(s.substring(i, i + 1))) {
                   int x= SYMBOLS.indexOf(s.substring(i, i+1));
                   if(x+key.getValue()>=SYMBOLS.length()) {
                       x=x-SYMBOLS.length();
                   }
                    stringBuilder.append(SYMBOLS.substring(x+key.getValue(), x+ key.getValue()+1));
                }
            }
            changedList.add(stringBuilder.toString());
        }
        return changedList;
    }
    public void writeText (ArrayList<String> list) {
        if(!Files.exists(outPath)) {
            try {
                Files.createFile(outPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outPath, Charset.defaultCharset())) {
                for (String line : list) {
                    bufferedWriter.write(line);
                }
            } catch (IOException e) {
                e.getMessage();
                System.out.println("Введено неіснуючий шлях");
            }


    }

}
