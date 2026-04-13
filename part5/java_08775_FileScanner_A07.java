import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_08775_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (DirectoryStream<Path> files = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path file : files) {
                BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                if (!attrs.isRegularFile()) {
                    // Skip directories and other file types
                    continue;
                }
                Files.lines(file).forEach(line -> {
                    // Security-sensitive operation here
                    // ...
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}