import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32770_FileScanner_A07 {

    public static void main(String[] args) {

        // Create a scanner to read the file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file path:");
        String filePath = scanner.nextLine();

        // Create a scanner to read the string to find
        System.out.println("Please enter the string to find:");
        String searchString = scanner.nextLine();

        // Initialize the count
        int count = 0;

        // Try to open the file
        try (Scanner fileScanner = new Scanner(new File(filePath))) {

            // While there are still lines in the file
            while (fileScanner.hasNextLine()) {

                // Get the next line
                String line = fileScanner.nextLine();

                // If the line contains the search string, increment the count
                if (line.contains(searchString)) {
                    count++;
                }
            }

        } catch (FileNotFoundException e) {
            // Handle the exception
            System.out.println("File not found: " + e.getMessage());
        }

        // Output the count
        System.out.println("The string '" + searchString + "' occurred " + count + " times.");
    }
}