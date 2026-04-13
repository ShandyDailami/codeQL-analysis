import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23192_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning directory: " + directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Found file: " + file.getName());
                    }
                }
            } else {
                System.out.println("Failed to list files in directory: " + directoryPath);
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}