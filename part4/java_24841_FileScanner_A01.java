import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24841_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}