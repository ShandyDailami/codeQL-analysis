import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_38475_FileScanner_A08 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                System.out.println("Line " + lineNumber + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file. Please try again.");
        }
    }
}