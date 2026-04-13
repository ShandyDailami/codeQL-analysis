import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_01931_FileScanner_A07 {

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt"; // replace with your file path
        long lineCount = countLines(filePath);
        System.out.println("Line count: " + lineCount);
    }

    private static long countLines(String filePath) {
        long lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}