import java.io.File;
import java.util.Scanner;

public class java_39383_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner that reads from the user's input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();

            // Create a File object using the entered file name
            File file = new File(fileName);

            // Create a Scanner that reads from the file
            Scanner fileScanner = new Scanner(file);

            // Print each line from the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // Close the Scanner
            fileScanner.close();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}