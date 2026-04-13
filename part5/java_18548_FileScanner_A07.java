import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18548_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner to list all files in the directory
        FileScanner scanner = new FileScanner(new File("."), ".*");
        
        // Start scanning
        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        
        // Close the scanner
        scanner.close();
    }
}