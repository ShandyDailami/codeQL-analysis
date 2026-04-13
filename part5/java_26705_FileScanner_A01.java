import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26705_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory we want to scan
        File directory = new File("C:\\path\\to\\directory");

        // Create a File array to hold all the file objects from the directory
        File[] files = directory.listFiles();

        // Check if there are any files in the directory
        if (files != null) {
            // Iterate through each file in the directory
            for (File file : files) {
                // Make sure the file is a regular file (not a directory or a device)
                if (file.isFile()) {
                    // Create a Scanner object for reading the file
                    Scanner scanner = new Scanner(file);

                    // Print out the contents of the file
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }

                    // Close the Scanner object
                    scanner.close();
                }
            }
        }
    }
}