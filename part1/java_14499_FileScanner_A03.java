import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_14499_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            // Creating a Scanner object for reading the file
            Scanner scanner = new Scanner(new File("C:\\path\\to\\your\\file.txt"));
            
            // Reading all the lines from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we are just printing the line, but in a real-world scenario,
                // we would typically not print the line here, but we'd have a more sophisticated
                // code to print the line, handle the line, etc.
                System.out.println(line);
            }

            // Closing the Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}