import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

public class java_07545_FileScanner_A07 {

    private static final Logger logger = Logger.getLogger(AuthFailure.class.getName());

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("C:/Users/yourdirectory"); // Change this to your directory

        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String name = file.toString();
                if (name.endsWith(".txt")) {
                    // Security sensitive operation
                    try {
                        Files.delete(file);
                        logger.info("Deleted file: " + file);
                    } catch (IOException e) {
                        logger.warning("Failed to delete file: " + file + ", Reason: " + e.getMessage());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}