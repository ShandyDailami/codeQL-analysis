import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24533_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current directory.
        File currentDir = new File(".");

        // Create a FileScanner for the current directory.
        FileScanner scanner = new FileScanner(currentDir);

        // Start scanning.
        scanner.scan();

        // Print out the names of the files found.
        while (scanner.hasNext()) {
            System.out.println(scanner.nextFileInfo().getName());
        }

        // Close the scanner.
        scanner.close();
    }
}