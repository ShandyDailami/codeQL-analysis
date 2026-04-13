import java.io.*;

public class java_19915_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        try (FileScanner scanner = new FileScanner(directory)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println("File: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}