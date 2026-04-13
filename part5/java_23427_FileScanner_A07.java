import java.io.File;
import java.util.Scanner;

public class java_23427_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");

        // Read the directory path from user input
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists()) {
            // Create a File object for the file
            File file = new File(directoryPath + "/authfailure.txt");

            // Check if the file exists
            if (file.exists()) {
                System.out.println("File authfailure.txt found in directory.");
            } else {
                System.out.println("File authfailure.txt not found in directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        // Close the scanner
        scanner.close();
    }
}