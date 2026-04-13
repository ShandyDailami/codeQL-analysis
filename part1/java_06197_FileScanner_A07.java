import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_06197_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) {
        // Create a Scanner for reading the command line arguments
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter directory path:");
        String directoryPath = scanner.nextLine();

        logger.info("Enter file name:");
        String fileName = scanner.nextLine();

        // Create a File object to represent the directory
        File directory = new File(directoryPath);

        // Create a File object to represent the file we want to read
        File file = new File(directory, fileName);

        // Check if the file exists
        if (!file.exists()) {
            logger.severe("File does not exist");
            return;
        }

        // Check if the file is a directory
        if (file.isDirectory()) {
            logger.severe("Provided path is a directory, not a file");
            return;
        }

        logger.info("Reading file: " + file.getAbsolutePath());

        // Create a Scanner for reading the file
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                logger.info(line);
            }
        } catch (Exception e) {
            logger.severe("Error reading file: " + e.getMessage());
        }
    }
}