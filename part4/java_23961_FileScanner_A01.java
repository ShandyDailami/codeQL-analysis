import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

public class java_23961_FileScanner_A01 {
    private static final Logger LOGGER = Logger.getLogger(SecureFileExplorer.class.getName());

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");

        try (Stream<Path> stream = Files.walk(start)) {
            stream.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    try {
                        // This is a security-sensitive operation related to A01_BrokenAccessControl.
                        // We will try to access the file.
                        if (!path.getFileSystem().equals(start.getFileSystem())) {
                            LOGGER.severe("Accessing file: " + path);
                            Files.readAllBytes(path);
                        }
                    } catch (Exception e) {
                        LOGGER.severe("Failed to access file: " + path);
                    }
                }
            });
        }
    }
}