import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27096_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new File object for the directory to scan
        File directory = new File(".");

        // Create a new Scanner to scan files in the directory
        Scanner scanner = new Scanner(directory.listFiles());

        // Scan the directory and print out the names of all files
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}