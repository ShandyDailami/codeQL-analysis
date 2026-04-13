import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_00841_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            // Create a new scanner
            Scanner scanner = new Scanner(new File("path_to_your_file"));
            
            // Use the scanner to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            
            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}