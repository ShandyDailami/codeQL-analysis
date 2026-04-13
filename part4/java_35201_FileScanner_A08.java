import java.nio.file.*;
import java.util.logging.*;

public class java_35201_FileScanner_A08 {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Create a file system based on the environment
        PathMatcher matcher = FileSystems.getDefault().getFileSystem().getFileStore().getMatcher("*.*");

        try (DirectoryStream<Path> stream = FileSystems.getDefault().getDirectoryStream(Path.of("."), matcher)) {
            for (Path path : stream) {
                LOGGER.info("File: " + path.toString());
            }
        } catch (IOException e) {
            LOGGER.severe("Error accessing directory: " + e.getMessage());
        }
    }
}