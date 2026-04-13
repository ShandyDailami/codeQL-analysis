import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_18053_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "/path/to/file.txt"; // replace with your file path
        String searchString = "A07_AuthFailure"; // replace with your search string
        scanFile(filePath, searchString);
    }

    private static void scanFile(String filePath, String searchString) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchString)) {
                    System.out.println("Line contains " + searchString);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}