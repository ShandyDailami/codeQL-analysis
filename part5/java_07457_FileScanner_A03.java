import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07457_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory to scan.
        File directory = new File(".");

        // Create a FileScanner object for scanning the directory.
        java.io.FileScanner fileScanner = new java.io.FileScanner(directory);

        // Scan the directory and print each filename.
        while (fileScanner.hasNext()) {
            String filename = fileScanner.next();
            System.out.println(filename);
        }

        // Close the FileScanner.
        fileScanner.close();
    }
}