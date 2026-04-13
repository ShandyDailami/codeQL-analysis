import java.nio.file.*;
import java.util.stream.*;

public class java_14361_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");
        searchForFile(startingPath);
    }

    private static void searchForFile(Path startingPath) {
        try (Stream<Path> paths = Files.walk(startingPath)) {
            paths.filter(Files::isRegularFile)
                .filter(path -> path.getFileName().toString().equals("AuthFailure.txt"))
                .forEach(path -> {
                    System.out.println("Found AuthFailure file at: " + path);
                    // Here you can add your security-sensitive operation related to A07_AuthFailure.
                });
        } catch (IOException e) {
            System.err.println("Failed to walk the directory tree.");
        }
    }
}