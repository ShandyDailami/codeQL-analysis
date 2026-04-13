import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_26475_FileScanner_A03 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt"; // replace with your file path
        String word = "injection"; // replace with the word you want to search for

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println("Line contains injection: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}