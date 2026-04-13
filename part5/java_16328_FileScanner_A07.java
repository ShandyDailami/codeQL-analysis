import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_16328_FileScanner_A07 {

    public static void main(String[] args) {
        String filePath = "/path/to/file.txt"; // replace with your file path
        String word = "AuthFailure";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}