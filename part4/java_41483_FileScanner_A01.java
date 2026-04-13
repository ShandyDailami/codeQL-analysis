import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_41483_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(FileScannerExample.class.getName());

    public static void main(String[] args) {
        logger.info("Starting file scanner...");

        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            logger.severe("Directory does not exist: " + directoryPath);
            System.exit(1);
        }

        try (FileScanner scanner = new FileScanner()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    logger.info("Found file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    logger.info("Found directory: " + file.getAbsolutePath());
                }
            }
        } catch (FileNotFoundException e) {
            logger.severe("File not found: " + e.getMessage());
            System.exit(1);
        }

        logger.info("File scanner finished.");
    }
}