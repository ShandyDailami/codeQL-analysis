import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_01768_FileScanner_A03 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("path_to_your_file"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}