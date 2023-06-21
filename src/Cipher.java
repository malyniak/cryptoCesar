import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class Cipher extends Caesar {
    private Path sourcePath;

    private final String SYMBOLS = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\":-? ";
    private Path outPath;
    private Key key;

    public void setKey(Key key) {
        this.key = key;
    }

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }
    public void setOutPath(Path outPath) {
        this.outPath = outPath;
    }
    public void encode() {
        this.writeText(cipheringText(readTextFromFile(sourcePath)), outPath);
    }

    public void decode() {
        ArrayList<String> strings = this.readTextFromFile(outPath);
        ArrayList<String> strings1 = this.decipheringText(strings);
        this.writeText(strings1, sourcePath);
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

    public ArrayList<String> cipheringText(ArrayList<String> strings) {
        ArrayList<String> changedList = new ArrayList<>();
        for (String s : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] charsOfLine = s.toCharArray();
            for (int i = 0; i < charsOfLine.length; i++) {
                if (SYMBOLS.contains(s.substring(i, i + 1))) {
                    int x = SYMBOLS.indexOf(s.substring(i, i + 1));
                    if (x + key.getValue() >= SYMBOLS.length()) {
                        x = x - SYMBOLS.length();
                    }
                    stringBuilder.append(SYMBOLS, x + key.getValue(), x + key.getValue() + 1);
                }
            }
            changedList.add(stringBuilder.toString());
        }
        return changedList;
    }

    public ArrayList<String> decipheringText(ArrayList<String> strings) {
        ArrayList<String> changedList = new ArrayList<>();
        for (String s : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] charsOfLine = s.toCharArray();
            for (int i = 0; i < charsOfLine.length; i++) {
                if (SYMBOLS.contains(s.substring(i, i + 1))) {
                    int x = SYMBOLS.indexOf(s.substring(i, i + 1));
                    if (x - key.getValue() < 0) {
                        x = SYMBOLS.length() + x ;
                    }
                    stringBuilder.append(SYMBOLS, x - key.getValue(), x - key.getValue() + 1);
                }
            }
            changedList.add(stringBuilder.toString());
        }
        return changedList;
    }

    public void initialize(Menu menu) {
        this.setSourcePath(menu.getSrcPath());
        this.setOutPath(menu.getOutPath());
        this.setKey(menu.getKey());
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
}