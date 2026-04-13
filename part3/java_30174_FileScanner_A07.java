import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_30174_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.txt";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("A07_AuthFailure")) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of lines containing 'A07_AuthFailure': " + count);
    }
}