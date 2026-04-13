import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39038_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        printDirectoryContents(directory);
    }

    public static void printDirectoryContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printDirectoryContents(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}