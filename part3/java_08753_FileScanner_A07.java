import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08753_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new FileScanner to scan the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Use the scanner to print out the names of all files in the current directory
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        // Close the scanner
        scanner.close();
    }
}