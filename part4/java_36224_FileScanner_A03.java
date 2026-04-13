import java.io.File;
import java.util.Scanner;

public class java_36224_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.print("Enter a directory: ");
        String directory = scanner.next();

        // Create a File object for the directory
        File dir = new File(directory);

        // Check if the directory exists
        if (dir.exists()) {
            System.out.println("Directory exists.");

            // Get all files in the directory
            File[] files = dir.listFiles();

            // Check if there are files
            if (files != null) {
                // Print out the names of all files
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}