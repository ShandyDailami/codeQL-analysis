import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31877_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Construct a FileScanner that scans for files in the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Use a Scanner to read each file's name
        Scanner fileScanner = new Scanner(scanner.files(".*\\.java$"));

        // While there are more files to read
        while (fileScanner.hasNext()) {
            // Get the next file name
            String fileName = fileScanner.next();

            // Open the file for reading
            Scanner fileScanner = new Scanner(new File(fileName));

            // While there are more lines in the file to read
            while (fileScanner.hasNext()) {
                // Get the next line
                String line = fileScanner.next();

                // Check if the line contains a password
                if (line.contains("password")) {
                    // If so, print a message
                    System.out.println("Found a password in file: " + fileName);
                }
            }

            // Close the file scanner
            fileScanner.close();
        }

        // Close the file scanner
        fileScanner.close();
    }
}