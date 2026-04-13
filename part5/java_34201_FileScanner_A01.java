import java.io.File;
import java.util.Scanner;

public class java_34201_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // Check if the directory exists and is readable
        if (directory.exists() && directory.isDirectory() && directory.canRead()) {
            for (File file : files) {
                // Print the name of each file
                System.out.println("File: " + file.getName());
            }
        } else {
            System.out.println("Directory does not exist or is not readable.");
        }
    }
}