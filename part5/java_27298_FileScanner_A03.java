import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_27298_FileScanner_A03 {
    public static void main(String[] args) {
        String filePath = "/path/to/file.txt"; // replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Security-sensitive operation: Printing the line
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}