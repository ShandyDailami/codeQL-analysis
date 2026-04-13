import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;
import java.util.logging.Logger.Level;

public class java_07145_FileScanner_A01 {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
    }

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:A*.txt");
        Files.walkFileTree(Paths.get("/home/user/directory"), matcher)
            .forEach(Main::logFile);
    }

    private static void logFile(Path path, BasicFileAttributes attrs,
                                 BasicFileAttributes empty) throws IOException {
        logger.info(() -> "Scanning file: " + path);
    }
}