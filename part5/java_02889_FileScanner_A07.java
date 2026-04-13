import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02889_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {

        // Create a new File instance for the directory we want to scan
        File dir = new File(".");

        // Create a new FileScanner object for this directory
        FileScanner scanner = new FileScanner(dir);

        // Scan the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();

            // Print the file or directory name
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}