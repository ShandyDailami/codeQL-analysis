import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_27857_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object representing the file to be read
        File file = new File(".");
        
        // Create a Scanner object to read the file
        Scanner scanner = new Scanner(file);
        
        // Use a while loop to read each line of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        
        // Close the scanner
        scanner.close();
    }
}