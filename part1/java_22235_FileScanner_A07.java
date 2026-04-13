import java.io.File;
import java.util.Scanner;

public class java_22235_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File instance to represent the directory to be scanned
        File directory = new File(".");

        // Create a FileScanner instance to scan the directory
        FileScanner scanner = new FileScanner(directory);

        // Use a Scanner to read input from the command line
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a filename
        System.out.println("Enter a filename:");
        String filename = input.nextLine();

        // Get the file based on the entered filename
        File file = new File(filename);

        // Check if the file exists and if it's a file
        if (file.exists() && file.isFile()) {
            // Check if the file is readable
            if (file.canRead()) {
                // Prompt the user to confirm the deletion of the file
                System.out.println("Are you sure you want to delete this file? (y/n)");
                String confirmation = input.nextLine();

                // Delete the file if the user confirms
                if (confirmation.equalsIgnoreCase("y")) {
                    if (file.delete()) {
                        System.out.println("File deleted successfully.");
                    } else {
                        System.out.println("Failed to delete file.");
                    }
                } else {
                    System.out.println("File deletion cancelled.");
                }
            } else {
                System.out.println("File is not readable.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        // Close the scanner
        scanner.close();
    }
}