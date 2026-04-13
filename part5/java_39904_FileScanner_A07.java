import java.io.File;
import java.util.Scanner;

public class java_39904_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");

        // Get the directory path from the user
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // List all files in the directory
        File[] files = dir.listFiles();

        // Check if the directory exists and is readable
        if (files != null && files.length > 0) {
            for (File file : files) {
                // Print the file name
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory does not exist or is not readable.");
        }

        // Close the scanner
        scanner.close();
    }
}