import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37837_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/your/file.txt");

        // Open file for reading
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Do something with the line
            // For example, check for SQL injection attacks
            if (line.contains("drop table")) {
                System.out.println("SQL Injection attack detected!");
            }
        }

        // Close scanner
        scanner.close();
    }
}