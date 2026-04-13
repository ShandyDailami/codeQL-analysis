import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_33079_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/A01_BrokenAccessControl/**");
        try (Stream<Path> paths = Files.find(Paths.get("/path/to/your/directory"), 1, matcher)) {
            paths.forEach(Main::processPath);
        }
    }

    private static void processPath(Path path) throws IOException {
        if (Files.isDirectory(path)) {
            System.out.println("Directory: " + path);
        } else {
            System.out.println("File: " + path);
        }
    }
}