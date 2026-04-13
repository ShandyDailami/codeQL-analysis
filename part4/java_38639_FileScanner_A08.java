import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_38639_FileScanner_A08 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("doesnotexist.txt"))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                System.out.println("Line " + lineNumber + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}