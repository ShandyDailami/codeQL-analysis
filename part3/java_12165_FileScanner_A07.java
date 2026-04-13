import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_12165_FileScanner_A07 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt";
        String sensitiveString = "A07_AuthFailure";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(sensitiveString)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}