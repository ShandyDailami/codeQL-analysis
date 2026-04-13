import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_15471_FileScanner_A08 {
    public static void main(String[] args) {
        String wordToSearch = "IntegrityFailure";
        String filePath = "src/main/resources/test.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordToSearch)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}