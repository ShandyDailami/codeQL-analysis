import java.io.File;
import java.util.Scanner;

public class java_29863_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a new Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for file path
        System.out.println("Enter the path to a file: ");
        String filePath = scanner.nextLine();

        // Try to create a new File object
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File exists");

            // Create a new Scanner for reading the file
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

        } else {
            System.out.println("File does not exist");
        }

        // Close the scanner
        scanner.close();
    }
}