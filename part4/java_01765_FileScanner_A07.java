import java.io.File;
import java.util.Scanner;

public class java_01765_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new scanner object to read the user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the keyword to search for:");
        String keyword = scanner.nextLine();

        File directory = new File(directoryPath);

        // Call the searchFiles method to get a list of file names with the keyword
        File[] files = directory.listFiles((dir, name) -> name.endsWith(keyword));

        // If there are no files with the keyword, print a message and exit
        if (files == null) {
            System.out.println("No files found with the keyword.");
            return;
        }

        // Print out the file names
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}