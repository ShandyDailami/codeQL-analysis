import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_36658_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        try (Stream<Path> stream = Files.walk(path)) {
            stream.forEach(file -> {
                if (Files.isRegularFile(file) && isSecuritySensitiveFile(file)) {
                    System.out.println("Security-sensitive file detected: " + file);
                }
            });
        }
    }

    private static boolean isSecuritySensitiveFile(Path file) {
        // This is a placeholder for a real implementation.
        // It should check the contents of the file against known patterns or vulnerabilities.
        // This is a very simplistic example, and doesn't actually check if the file contains a known injection attack.
        // It's just a demonstration of how to use File.listFiles() and Files.isRegularFile() in a secure way.

        String name = file.getFileName().toString();
        return name.endsWith(".java") || name.endsWith(".js");
    }
}