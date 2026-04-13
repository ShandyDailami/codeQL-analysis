import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15845_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Scanner for reading the file in the current directory
        Scanner scanner = new Scanner(new File("."));

        // Print out each file name found
        while (scanner.hasNext()) {
            String fileName = scanner.next();
            System.out.println(fileName);
        }

        // Close the scanner
        scanner.close();
    }
}