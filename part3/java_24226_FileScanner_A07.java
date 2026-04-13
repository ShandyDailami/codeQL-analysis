import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24226_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");
        long maxSize = 500;
        scanFilesInDirectory(directory, maxSize);
    }

    public static void scanFilesInDirectory(File directory, long maxSize) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanFilesInDirectory(file, maxSize);
                } else if (file.length() > maxSize) {
                    System.out.println("Large file: " + file.getAbsolutePath());
                }
            }
        }
    }
}