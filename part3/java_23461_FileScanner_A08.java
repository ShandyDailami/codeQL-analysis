import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_23461_FileScanner_A08 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt"; // Replace with your file path
        String pattern = "desired pattern"; // Replace with your desired pattern

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(pattern)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}