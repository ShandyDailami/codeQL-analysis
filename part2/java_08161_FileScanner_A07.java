import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08161_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner for the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Use the scanner to find all files in the current directory
        File[] files = scanner.findAll();

        // Print out the names of all the files
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}