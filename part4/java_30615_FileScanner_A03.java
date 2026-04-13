import java.io.File;
import java.util.Scanner;

public class java_30615_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for file path
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        // Create a FileScanner
        File file = new File(filePath);
        Scanner fileScanner = null;

        try {
            // Open the file
            fileScanner = new Scanner(file);

            // Read and print out the file contents
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            // Close the fileScanner
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
        }

        // Close the scanner
        scanner.close();
    }
}