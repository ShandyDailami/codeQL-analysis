import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_39812_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "src/main/resources/authFailure.txt"; // replace with your file path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}