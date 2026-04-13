import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_36994_FileScanner_A08 {

    // The directory to scan
    private static final Path start = Paths.get(".").toAbsolutePath();

    public static void main(String[] args) throws IOException, InterruptedException {
        Files.walk(start)
            .filter(Files::isRegularFile)
            .forEach(file -> {
                try (Stream<String> lines = Files.lines(file)) {
                    lines.forEach(line -> {
                        if (line.contains("A08_IntegrityFailure")) {
                            System.out.println("Found file: " + file.toString());
                        }
                    });
                }
            });
    }
}