import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38310_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Remove the comment and replace it with the correct path
        File file = new File("path/to/your/file.txt");

        // Use the Scanner class from the standard library
        Scanner scanner = new Scanner(file);

        // Read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line); // Print the line to see if it's readable
        }

        // Close the scanner
        scanner.close();
    }
}