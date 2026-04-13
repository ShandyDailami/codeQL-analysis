import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_26520_FileScanner_A03 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            logger.info("Enter the file extension to filter:");
            String fileExtension = scanner.nextLine();

            File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (textFiles != null) {
                for (File textFile : textFiles) {
                    if (textFile.isFile()) {
                        logger.info("File: " + textFile.getAbsolutePath());
                    }
                }
            } else {
                logger.warning("No text files found in directory.");
            }
        } else {
            logger.warning("Invalid directory or it's not a directory.");
        }

        scanner.close();
    }
}