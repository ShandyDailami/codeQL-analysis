import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_00412_FileScanner_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.txt";  // replace with your file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}