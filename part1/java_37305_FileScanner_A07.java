import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_37305_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "./auth.txt"; // Assuming the file is in the same directory
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (line.contains("password")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}