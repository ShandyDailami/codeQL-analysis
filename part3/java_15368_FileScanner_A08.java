import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15368_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a new file scanner to scan for files in the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Scan each file in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();

            // Print out the details of the file
            System.out.println("File: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Last Modified: " + file.lastModified());
            System.out.println("Is File: " + file.isFile());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("-------------------");
        }

        // Close the scanner
        scanner.close();
    }

}