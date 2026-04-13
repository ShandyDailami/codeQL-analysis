import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16083_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory to scan
        File directory = new File(".");

        // Use a FileScanner to scan the directory
        Scanner scanner = new Scanner(directory);

        // Print out all the files in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}