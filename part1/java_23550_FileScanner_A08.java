import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23550_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object to represent the root directory
        File rootDirectory = new File(".");

        // Create a Scanner object to read the input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a pattern
        System.out.println("Enter a pattern: ");
        String pattern = scanner.nextLine();

        // Use the File.list() method to find files in the root directory
        // that match the pattern
        File[] matchingFiles = rootDirectory.listFiles((dir, name) -> name.matches(pattern));

        // Check if any matching files were found
        if (matchingFiles != null) {
            // Print the names of the matching files
            for (File file : matchingFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found matching the pattern.");
        }
    }
}