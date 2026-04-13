import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30748_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we are using String manipulation to break down the line into parts for security-sensitive operations
                if (line.contains("sensitive_operation")) {
                    System.out.println("Sensitive operation detected: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}