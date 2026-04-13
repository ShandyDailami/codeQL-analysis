import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_01736_FileScanner_A03 {
    public static void main(String[] args) {
        String filePath = "path/to/file.txt";  // Replace with your file path
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
           
                // Security-sensitive operation: Injecting a malicious line into the file
                // If this operation is not done properly, it could lead to remote code execution or other security issues
                System.out.println("A03_Injection: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}