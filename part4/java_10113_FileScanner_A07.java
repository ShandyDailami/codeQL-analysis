import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10113_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new File object for the directory you want to scan
        File directory = new File(".");

        // Create a new FileScanner object for the directory
        java.io.FileScanner fileScanner = new java.io.FileScanner(directory);

        // Use a while loop to scan the directory and print out each file name
        while (fileScanner.hasNext()) {
            System.out.println(fileScanner.next());
        }

        // Close the FileScanner
        fileScanner.close();
    }
}