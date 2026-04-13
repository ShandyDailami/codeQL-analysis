import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_24987_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a file name
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Create a File object for the input file name
        File file = new File(fileName);

        // Check if the file exists
        if (file.exists()) {
            // Create a Scanner for the file
            try (Scanner fileScanner = new Scanner(file)) {
                // Read the file line by line
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist: " + fileName);
        }
    }
}