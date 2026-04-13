import java.io.File;
import java.util.Scanner;

public class java_30561_FileScanner_A01 {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the file path
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        // Create a File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
            // Create a Scanner object for the file
            Scanner fileScanner = new Scanner(file);

            // Print out the contents of the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // Close the Scanner object
            fileScanner.close();
        } else {
            System.out.println("File not found.");
        }

        // Close the Scanner object
        scanner.close();
    }
}