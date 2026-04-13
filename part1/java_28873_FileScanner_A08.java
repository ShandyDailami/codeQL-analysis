import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_28873_FileScanner_A08 {
    private static final Logger logger = Logger.getLogger(SecureFileScanner.class.getName());

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            logger.warning("Directory does not exist: " + directoryPath);
            return;
        }

        if (!directory.canRead()) {
            logger.warning("Insufficient permissions to read directory: " + directoryPath);
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            logger.warning("Unable to list files in directory: " + directoryPath);
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                if (file.length() > 1000) {
                    logger.warning("File is too large: " + file.getName());
                } else {
                    logger.info("Found file: " + file.getName());
                }
            } else if (file.isDirectory()) {
                logger.info("Found directory: " + file.getName());
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory("/path/to/directory");
    }
}