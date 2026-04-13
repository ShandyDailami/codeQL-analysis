import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_17736_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";
        String pattern = "A07_AuthFailure";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pattern)) {
                    System.out.println("Line contains pattern: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}