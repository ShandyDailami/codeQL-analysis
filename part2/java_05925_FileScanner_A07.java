import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05925_FileScanner_A07 {

    private File file;

    public java_05925_FileScanner_A07(String filePath) {
        file = new File(filePath);
    }

    public void scanFile() {
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Perform security-sensitive operations here.
                    // For example, check if the line contains sensitive information.
                    if (containsSensitiveInformation(line)) {
                        System.out.println("Suspicious activity detected in file: " + file.getName());
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getName());
            }
        } else {
            System.out.println("File not found: " + file.getName());
        }
    }

    private boolean containsSensitiveInformation(String line) {
        // You can implement a method to check the line for any sensitive information here.
        // For example, you can check if the line contains any email addresses or credit card numbers.
        // This is a placeholder and you should replace it with your own logic.
        return line.contains("sensitive information");
    }

    public static void main(String[] args) {
        LegacyFileScanner scanner = new LegacyFileScanner("path/to/file");
        scanner.scanFile();
    }
}