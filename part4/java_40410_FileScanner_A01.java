import java.io.File;
import java.util.Scanner;

public class java_40410_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new file instance
        File file = new File("./example.txt");

        // Check if the file exists
        if (file.exists()) {
            try {
                // Create a new scanner for the file
                Scanner scanner = new Scanner(file);

                // Read and print the file contents
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }

                // Close the scanner
                scanner.close();
            } catch (Exception e) {
                // Handle any exceptions that may occur
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found!");
        }
    }
}