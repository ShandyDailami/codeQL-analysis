import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39269_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "."; // Change this to the directory you want to scan
        File directory = new File(directoryPath);

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) throws FileNotFoundException {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
            } else {
                System.out.println("Directory: " + file.getAbsolutePath());
                printFilesInDirectory(file); // Recursive call
            }
        }
    }
}