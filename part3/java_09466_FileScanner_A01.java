import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_09466_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("directory-path");

        try (Stream<Path> stream = Files.walk(path)) {
            long count = stream.filter(Files::isRegularFile).filter(Main::isSecuritySensitive).count();

            System.out.println("Number of security-sensitive files: " + count);
        }
    }

    private static boolean isSecuritySensitive(Path path) {
        // Assuming the file is secure if it contains a certain keyword (example)
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.lines().anyMatch(line -> line.contains("example"));
        } catch (IOException e) {
            return false; // The file is not accessible, so it is not security-sensitive
        }
    }
}