import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class java_08620_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a HashSet to store unique lines
        HashSet<String> uniqueLines = new HashSet<>();

        // Try to read the file
        try (BufferedReader reader = new BufferedReader(new FileReader("legacy-file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Add the line to the HashSet
                uniqueLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print out the unique lines
        for (String line : uniqueLines) {
            System.out.println(line);
        }
    }
}