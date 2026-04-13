import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

public class java_15067_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".").toAbsolutePath();
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths.forEach(Main::printFileOrDirectory);
        }
    }

    private static void printFileOrDirectory(Path path) {
        if (Files.isDirectory(path)) {
            logger.info("Directory: " + path);
        } else if (Files.isReadable(path)) {
            logger.info("File: " + path);
        } else {
            logger.warning("Unreadable file: " + path);
        }
    }
}