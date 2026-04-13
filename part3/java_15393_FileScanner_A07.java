import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15393_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        printFiles(directory);
    }

    public static void printFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }
}