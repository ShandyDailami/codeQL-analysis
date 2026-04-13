import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_16145_FileScanner_A01 {
    private static final Logger LOGGER = Logger.getLogger(BrokenAccessControl.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Starting program...");

        // Create a scanner to get input from the user.
        try (Scanner scanner = new Scanner(System.in)) {
            LOGGER.info("Please enter a directory path:");
            String directoryPath = scanner.next();

            // Check if the directory exists.
            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                LOGGER.severe("Invalid directory path. Please try again.");
                return;
            }

            LOGGER.info("Scanning files in directory...");
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                LOGGER.info(line);
                            }
                        } catch (FileNotFoundException e) {
                            LOGGER.severe("Failed to read file: " + file.getName());
                        }
                    }
                }
            } else {
                LOGGER.severe("Failed to get files from directory: " + directoryPath);
            }
        } catch (Exception e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
        }

        LOGGER.info("Exiting program...");
    }
}