import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31641_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory path
        String directoryPath = "/path/to/directory";

        // Use File class to create a File object
        File directory = new File(directoryPath);

        // Create a File object array to store all files in the directory
        File[] files = directory.listFiles();

        // If files exist, loop through them and print their names
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File absolute path: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}