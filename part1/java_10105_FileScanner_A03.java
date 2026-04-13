import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10105_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory to start scanning from
        File directory = new File(".");

        // Create a FileScanner object that uses the File object to initialize
        FileScanner scanner = new FileScanner(directory);

        // Use the scanner object to recursively scan all files and subdirectories
        scanner.scan(directory, true);

        // Print the file names
        while(scanner.hasNext()) {
            System.out.println(scanner.nextFile());
        }

        // Close the scanner
        scanner.close();
    }
}