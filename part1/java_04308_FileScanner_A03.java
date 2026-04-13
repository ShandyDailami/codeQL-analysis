import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_04308_FileScanner_A03 {

    public static void main(String[] args) {
        String fileName = "/path/to/file";  // replace with your file path
        String keyword = "injection";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println("Line contains injection: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}