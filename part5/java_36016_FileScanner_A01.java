import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_36016_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");  // Start from current directory
        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(path -> {
                if (Files.isRegularFile(path) && path.toString().endsWith(".txt")) {
                    System.out.println(path.toString());
                }
            });
        }
    }
}