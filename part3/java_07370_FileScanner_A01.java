import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_07370_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the directory they want to scan
        System.out.println("Please enter the directory you want to scan:");
        String directoryPath = scanner.nextLine();

        // Create a new File object for the directory
        File directory = new File(directoryPath);

        // If the directory does not exist, print an error message and exit
        if (!directory.exists()) {
            System.out.println("The directory does not exist.");
            System.exit(1);
        }

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // If there are no files, print an error message and exit
        if (files == null) {
            System.out.println("The directory is empty.");
            System.exit(1);
        }

        // Print out the content of each file
        for (File file : files) {
            try {
                // Create a new Scanner object for the file content
                Scanner fileScanner = new Scanner(file);

                // Print out the content of the file
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }

                // Close the Scanner
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}