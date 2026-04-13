import java.io.File;
import java.util.Scanner;

public class java_19858_FileScanner_A08 {

    public static void main(String[] args) {

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(dirPath);

        // Get all the files in the directory and its subdirectories
        File[] allFiles = directory.listFiles();

        // Iterate over all the files
        for (File file : allFiles) {
            if (file.isFile()) {
                // Check if the file is a text file
                if (file.getName().endsWith(".txt")) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}