import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12527_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "/path/to/your/file.txt";

        // Create a new File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
            try {
                // Create a new Scanner for the file
                Scanner scanner = new Scanner(file);

                // Print out the content of the file
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                // Close the scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else {
            System.out.println("File does not exist");
        }
    }
}