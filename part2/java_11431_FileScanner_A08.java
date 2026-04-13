import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11431_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a File instance to represent the directory
        File directory = new File(".");

        // Use FileScanner to iterate over all files in directory
        Scanner fileScanner = new Scanner(directory);

        // Iterate over each file in the directory
        while (fileScanner.hasNext()) {
            // Get the next file name
            String fileName = fileScanner.next();

            // Print the file name
            System.out.println("File name: " + fileName);
        }

        // Close the scanner
        fileScanner.close();
    }
}