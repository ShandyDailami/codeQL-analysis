import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16470_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object that represents the directory to be scanned
        File directory = new File(".");

        // Create a Scanner object to read from the directory
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            // While there are still files to read
            while (scanner.hasNext()) {
                // Get the next file name
                String fileName = scanner.next();

                // Print the file name
                System.out.println("File: " + fileName);

                // Try to open the file
                try (Scanner fileScanner = new Scanner(new File(fileName))) {
                    // While there are still lines in the file
                    while (fileScanner.hasNext()) {
                        // Get the next line from the file
                        String fileLine = fileScanner.nextLine();

                        // Print the line
                        System.out.println("Line: " + fileLine);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error: File not found");
                }
            }
        }
    }
}