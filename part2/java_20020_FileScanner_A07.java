import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_20020_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            // Prompt user for file name
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the file name: ");
            String fileName = input.nextLine();

            // Create a File object
            File file = new File(fileName);

            // Check if file exists
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            // Check if file is a regular file
            if (!file.isFile()) {
                System.out.println("Not a file.");
                return;
            }

            // Check if file is readable
            if (!file.canRead()) {
                System.out.println("Cannot read file.");
                return;
            }

            // Initialize a Scanner to read the file
            Scanner scanner = new Scanner(file);

            // Print out the content of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}