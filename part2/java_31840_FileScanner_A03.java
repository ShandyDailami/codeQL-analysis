import java.io.*;

public class java_31840_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = ".";
        String fileName = "test.txt";
        String fullPath = directory + File.separator + fileName;

        File file = new File(fullPath);

        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error scanning file: " + e.getMessage());
        }
    }
}