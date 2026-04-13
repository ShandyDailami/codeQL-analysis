import java.io.IOException;
import java.nio.file.*;

public class java_26771_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");

        Files.walk(Paths.get("."))
            .filter(path -> matcher.matches(path))
            .forEach(path -> {
                try {
                    Path file = path;
                    long size = Files.size(file);
                    String name = file.toString();
                    System.out.printf("File '%s' has size %d bytes%n", name, size);
                } catch (Exception ex) {
                    System.err.printf("Failed to process file: %s%n", path);
                }
            });
    }
}