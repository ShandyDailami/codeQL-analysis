import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36225_FileScanner_A01 {

    public static void main(String[] args) {
        // Create a File object for the directory we want to scan
        File dir = new File("path/to/directory");

        try {
            // Create a FileScanner object
            Scanner scanner = new Scanner(dir);

            // Use a while loop to scan the directory
            while (scanner.hasNext()) {
                File file = scanner.nextFile();

                // If the file is a directory, print a message
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                }
                // If the file is a file, print a message
                else if (file.isFile()) {
                    System.out.println("File: " + file.getPath());
                }
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}