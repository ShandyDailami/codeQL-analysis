import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_39403_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) {
        String directoryPath = "path/to/directory";

        File directory = new File(directoryPath);

        logger.info("Starting file scanner...");

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        logger.info("Found file: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        logger.info("Found directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                logger.warning("No files found in the directory: " + directoryPath);
            }
        } else {
            logger.warning("Directory does not exist: " + directoryPath);
        }

        logger.info("File scanner finished.");
    }
}