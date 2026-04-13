import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_21605_FileScanner_A08 {

    public static void main(String[] args) {
        String filePath = "/path/to/file"; // Specify your file path
        String pattern = "pattern"; // Specify your pattern

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pattern)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}