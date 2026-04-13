import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14729_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory to be scanned
        File directory = new File(".");

        // Use File.listFiles to get an array of all files in the directory
        File[] listOfFiles = directory.listFiles();

        // Iterate over each file in the array
        for (File file : listOfFiles) {
            // If the file is a regular file (not a directory)
            if (file.isFile()) {
                // Create a new Scanner object to read the file
                Scanner scanner = new Scanner(file);

                // Use a while loop to read each line in the file
                while (scanner.hasNextLine()) {
                    // Get the next line from the file
                    String line = scanner.nextLine();

                    // Print the line
                    System.out.println(line);
                }

                // Close the scanner
                scanner.close();
            }
        }
    }
}