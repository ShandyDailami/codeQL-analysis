import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31422_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory
        File directory = new File(".");

        // Create a Scanner object for the directory
        Scanner scanner = new Scanner(directory.listFiles());

        // Enumerate through all the files in the directory
        while (scanner.hasNext()) {
            String fileName = scanner.next();
            System.out.println(fileName);
        }

        // Close the scanner
        scanner.close();
    }
}