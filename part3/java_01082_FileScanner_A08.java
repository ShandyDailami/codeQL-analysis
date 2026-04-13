import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Logger;

public class java_01082_FileScanner_A08 {
    private static final Logger LOGGER = Logger.getLogger(FileScanner.class.getName());

    private static final String DIRECTORY = "src/main/resources/";
    private static final String FILE_NAME = "a.txt";

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath(DIRECTORY);
        File file = path.toFile();

        if (file.exists()) {
            try {
                FileSystems.getDefault().delete(path);
                LOGGER.info("Directory deleted successfully");
            } catch (IOException e) {
                LOGGER.severe("Failed to delete directory: " + e.getMessage());
            }
        } else {
            LOGGER.info("Directory does not exist");
        }
    }
}