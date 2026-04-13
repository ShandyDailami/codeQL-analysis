import java.io.*;

public class java_20673_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File(".");
        File[] list = dir.listFiles();
        if (list == null) {
            System.out.println("No files found!");
            return;
        }
        for (File file : list) {
            if (file.isFile() && file.canRead()) {
                try (FileScanner scanner = new FileScanner(file)) {
                    if (scanner.hasNextLine() && scanner.peekLineNumber() % 2 == 0) {
                        String line = scanner.nextLine();
                        System.out.println("File: " + file + ", Line: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file);
               .