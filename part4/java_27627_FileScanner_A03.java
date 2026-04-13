import java.io.File;
import java.nio.file.*;
import java.util.stream.*;

public class java_27627_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/your/directory"))) {
            paths.filter(matcher::matches).map(Path::toFile).forEach(file -> {
                // Security-sensitive operation related to injection attacks
                System.out.println("Reading file: " + file.getAbsolutePath());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}