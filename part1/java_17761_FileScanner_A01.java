import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17761_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new file object for the file to be scanned.
        File file = new File("src/main/resources/accessControlFile.txt");
        
        // Create a Scanner object for reading the file.
        Scanner scanner = new Scanner(file);
        
        // Use a while loop to read the file line by line.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            // You can implement security-sensitive operations here.
            // For example, you might check if a line contains a certain password.
            if (line.contains("password")) {
                System.out.println("Password found in the file.");
            }
        }
        
        // Close the scanner.
        scanner.close();
    }
}