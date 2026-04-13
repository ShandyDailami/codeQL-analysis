import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_21722_FileScanner_A08 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt";

        long lineCount = 0;
        long totalCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                totalCount += line.length();
                System.out.println("Line " + lineCount + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Total lines: " + totalCount);
    }
}