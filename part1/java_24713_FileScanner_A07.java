import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_24713_FileScanner_A07 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
    }
}