import java.io.*;

public class java_13992_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (FileScanner scanner = new FileScanner()) {
            scanner.init(directory);

            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error scanning directory: " + e.getMessage());
        }
    }
}