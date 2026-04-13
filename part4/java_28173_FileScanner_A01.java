import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_28173_FileScanner_A01 {
    public static void main(String[] args) {
        String filePath = "example.txt";
        int lineNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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