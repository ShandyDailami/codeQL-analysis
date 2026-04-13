import java.io.*;
import java.nio.file.*;

public class java_37856_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.txt")) {
            for (Path file : dirs) {
                try (BufferedReader reader = Files.newBufferedReader(file)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Implement your security-sensitive operations related to A07_AuthFailure here
                        // For example, checking if the line contains a known failure flag
                        if (line.contains("A07_AuthFailure")) {
                            System.out.println("Potential AuthFailure detected in file: " + file.toString());
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + path.toString());
        }
    }
}