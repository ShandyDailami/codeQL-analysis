import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_03654_FileScanner_A07 {
    public static void main(String[] args) {
        // Start reading from a specific line
        int specificLine = 5;

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (lineNumber == specificLine) {
                    System.out.println("Stopped reading at line " + lineNumber);
                    break;
                }
                System.out.println("Read line " + lineNumber + ": " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}