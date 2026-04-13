import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18134_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "."; // Change this to the directory you want to scan
        File directory = new File(directoryPath);
        
        printFilesInDirectory(directory);
    }

    public static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}