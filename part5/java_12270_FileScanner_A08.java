import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12270_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Create a scanner for reading input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a filename
        System.out.println("Enter a filename:");
        String filename = scanner.next();

        // Search for the file in the list
        for (File file : files) {
            if (file.getName().equals(filename)) {
                // If the file exists, print its content
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            }
        }

        // Close the scanner
        scanner.close();
    }
}