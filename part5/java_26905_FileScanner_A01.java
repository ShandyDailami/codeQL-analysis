import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26905_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object that points to the directory we are going to scan.
        File directory = new File(".");

        // Use a FileScanner to scan the directory and its subdirectories.
        FileScanner fileScanner = new FileScanner(directory);

        // Use a Scanner to read the input.
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many files they want to display.
        System.out.println("How many files do you want to display?");
        int numFiles = scanner.nextInt();

        // Use a counter to keep track of how many files we have found.
        int numFilesFound = 0;

        // Use a loop to scan the directory and its subdirectories.
        while (numFilesFound < numFiles) {
            // Get the next file in the directory.
            File file = fileScanner.nextFile();

            // If the file is not null, then we have found a file.
            if (file != null) {
                // Print the name of the file.
                System.out.println(file.getName());

                // Increment the counter.
                numFilesFound++;
            }
        }

        // Close the scanner.
        scanner.close();
    }
}