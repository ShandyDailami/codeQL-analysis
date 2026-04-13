import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37361_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("")); // Scanning the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Security-sensitive operation here. For example, checking if the line contains any sensitive information.
                if (line.contains("SENSITIVE_INFORMATION")) {
                    System.out.println("Found sensitive information in the file: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

}