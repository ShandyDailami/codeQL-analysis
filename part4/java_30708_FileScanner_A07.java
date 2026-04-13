import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30708_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFileName(File file) throws FileNotFoundException {
        System.out.println(file.getName());
    }
}