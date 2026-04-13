import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36631_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Sensitive operation here, such as reading from a file or accessing a database
                // The operation here is not shown as the question does not specify any such operations

                // Print out the sensitive data
                System.out.println("Sensitive data: " + line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}