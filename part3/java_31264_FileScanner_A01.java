import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_31264_FileScanner_A01 {

    public void scanFile(String filePath, String searchTerm) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    System.out.println("Found: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanFile("path/to/your/file", "searchTerm");
    }
}