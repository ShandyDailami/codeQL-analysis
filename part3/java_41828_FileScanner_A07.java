import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_41828_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new scanner to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.println("Enter a directory:");
        String directory = scanner.next();

        // Create a new file
        File file = new File(directory);

        // Check if the directory exists
        if (file.exists() && file.isDirectory()) {
            // Get all the files in the directory
            File[] listOfFiles = file.listFiles();

            // If the directory is not empty, print the file names
            if (listOfFiles != null) {
                Arrays.stream(listOfFiles).forEach(System.out::println);
            } else {
                System.out.println("No file in the directory.");
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }

        // Close the scanner
        scanner.close();
    }
}