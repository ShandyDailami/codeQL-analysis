import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_12708_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory path
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object and use File.listRoots() to get a list of root directories
        File[] roots = File.listRoots();

        // Create a new File object for the directory path
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists()) {
            // Print the list of file names in the directory
            System.out.println("File names in the directory: " + Arrays.toString(directory.list()));
        } else {
            System.out.println("Directory does not exist.");
        }

        // Close the Scanner
        scanner.close();
    }
}