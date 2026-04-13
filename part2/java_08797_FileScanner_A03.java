import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_08797_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        PathMatchingStrategy strategy = Paths.get(".");
        Stream<Path> results = Files.find(
                strategy.matching(Files.FilesOnly.not(Files.isDirectory()), // we only look for files not directories
                Paths.get("/path/to/your/files"), // starting point
                Integer.MAX_VALUE // max depth
        );

        results.forEach(path -> {
            if (path.toString().endsWith(".txt")) {
                Files.lines(path).forEach(line -> {
                    if (line.contains("your_target_string")) {
                        System.out.println("Found string in file: " + path.toString());
                    }
                });
            }
        });
    }
}