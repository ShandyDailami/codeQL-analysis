import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02428_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "./"; // Specify your directory here
        File directory = new File(directoryPath);

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printFilesInDirectory(file);
                }
            }
        }
    }
}