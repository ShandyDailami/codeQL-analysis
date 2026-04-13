import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_07302_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public void scanFiles(String directoryPath, String fileExtension) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        logger.info("Found file: " + file.getPath());

                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                logger.info("Line in file: " + line);
                            }
                        }
                    }
                }
            } else {
                logger.info("No files found in directory with extension: " + fileExtension);
            }
        } else {
            logger.info("Directory does not exist or it's not a directory: " + directoryPath);
        }
    }
}