import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_35836_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new File object for the test.txt file
        File file = new File("test.txt");

        // Check if the file exists
        if (file.exists()) {
            try {
                // Create a new Scanner object for the file
                Scanner scanner = new Scanner(file);

                // Use a while loop to read the file line by line
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