import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_09821_FileScanner_A01 {
    public static void main(String[] args) {
        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/directory"))) {
            paths.forEach(file -> {
                if (Files.isRegularFile(file)) {
                    try (Stream<String> lines = Files.lines(file)) {
                        lines.forEach(line -> {
                            // Perform security sensitive operations here
                            System.out.println(line);
                        });
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}