import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40102_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "."; // current directory
        searchFiles(directoryPath);
    }

    public static void searchFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".java")) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    searchFiles(file.getAbsolutePath());
                }
            }
        }
    }
}