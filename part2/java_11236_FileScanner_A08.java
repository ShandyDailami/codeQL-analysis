import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11236_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File instance for the directory we want to scan
        File directory = new File(".");

        // Create a Scanner instance to scan the directory for files
        Scanner scanner = new Scanner(directory);

        // Use a while loop to go through all the files in the directory
        while (scanner.hasNext()) {
            // Get the next file in the directory
            File file = scanner.next();

            // Check if the file is a text file
            if (file.isFile() && file.getName().endsWith(".txt")) {
                // Create a Scanner instance to read the contents of the text file
                Scanner fileScanner = new Scanner(file);

                // Use a while loop to go through all the lines in the text file
                while (fileScanner.hasNext()) {
                    // Print the next line in the text file
                    System.out.println(fileScanner.nextLine());
                }

                // Close the Scanner
                fileScanner.close();
            }
        }

        // Close the Scanner
        scanner.close();
    }
}