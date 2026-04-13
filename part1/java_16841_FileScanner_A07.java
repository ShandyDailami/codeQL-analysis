import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

public class java_16841_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");

        Files.newDirectoryStream(path, "*.txt")
            .forEach(file -> {
                try (Stream<String> lines = Files.lines(file)) {
                    lines.forEach(line -> {
                        if (line.contains("A07_AuthFailure")) {
                            logger.info("File: " + file.toString() + ", Line: " + line);
                        }
                    });
                }
            });
    }
}