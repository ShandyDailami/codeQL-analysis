import java.nio.file.*;
import java.util.logging.Logger;

public class java_26953_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(SecureFileScanner.class.getName());

    private static final String FILE_PATTERN = "*.txt";
    private static final String SECURITY_OPERATION = "Applying security operation to file";

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:'" + FILE_PATTERN + "'");
        try (DirectoryStream<Path> files = Files.newDirectoryStream(Paths.get("C:\\Temp"), matcher)) {
            for (Path file : files) {
                logger.info(SECURITY_OPERATION + ": " + file.toString());
                // Replace the following line with your own security-sensitive operation
                // For example, we'll just print the file size
                logger.info("File size: " + Files.size(file));
            }
        } catch (IOException e) {
            logger.severe("Error scanning directory: " + e.getMessage());
        }
    }
}