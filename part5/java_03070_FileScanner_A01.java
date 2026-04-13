import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_03070_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(FileScannerExample.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            logger.warning("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            logger.warning("Entered path is not a directory!");
            return;
        }

        logger.info("Scanning directory: " + directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    logger.info("File: " + file.getName());
                } else if (file.isDirectory()) {
                    logger.info("Directory: " + file.getName());
                }
            }
        } else {
            logger.warning("Failed to list files in directory!");
        }

        scanner.close();
    }
}