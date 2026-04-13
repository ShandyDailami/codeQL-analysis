import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class java_00273_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("path/to/file.txt"); // replace with your file path

        try (Scanner scanner = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (line.contains("auth failure")) {
                    System.out.println("Auth failure detected in: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}