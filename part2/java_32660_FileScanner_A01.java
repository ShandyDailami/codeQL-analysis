import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_32660_FileScanner_A01 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file"; // Replace with your file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lineNumber = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                System.out.println("Line " + lineNumber + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}