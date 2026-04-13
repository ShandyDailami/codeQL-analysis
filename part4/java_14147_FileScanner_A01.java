import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14147_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the directory to be scanned
        File directory = new File(".");

        // Scan the directory
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            // For each file in the directory
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                // If the file is a directory
                if (file.isDirectory()) {
                    // Print a message
                    System.out.println("Directory: " + file.getAbsolutePath());
                } else {
                    // If the file is a regular file
                    // Print a message
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}