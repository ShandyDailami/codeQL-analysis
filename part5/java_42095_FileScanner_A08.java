import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42095_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner that will scan the current directory
            FileScanner fileScanner = new FileScanner(new File("."));

            // Print out the names of all files in the current directory
            while (fileScanner.hasNext()) {
                String fileName = fileScanner.next();
                System.out.println(fileName);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while scanning the directory: " + e.getMessage());
        }
    }
}