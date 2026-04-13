import java.io.*;

public class java_14301_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("/path/to/your/file");

        try (FileScanner scanner = new FileScanner()) {
            scanner.initialize(file);

            while (scanner.hasNext()) {
                File nextFile = scanner.next();
                // Handle file here, e.g., print file name
                System.out.println("Processing file: " + nextFile.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}