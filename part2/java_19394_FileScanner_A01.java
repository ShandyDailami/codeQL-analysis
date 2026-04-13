import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_19394_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            logger.severe("Directory does not exist or it is not a directory!");
            System.exit(1);
        }

        logger.info("Scanning files in directory: " + directory.getAbsolutePath());

        File[] files = directory.listFiles();

        if (files == null) {
            logger.severe("Error occurred while listing files in the directory!");
            System.exit(1);
        }

        for (File file : files) {
            if (file.isFile()) {
                logger.info("File found: " + file.getName());
                // add code to read and process the file
                // for instance, print the first 100 characters of the file
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.length() <= 100) {
                            logger.info("Processing line: " + line);
                        } else {
                            logger.warning("Skipping line: " + line);
                        }
                    }
                } catch (Exception e) {
                    logger.severe("Error occurred while processing file: " + file.getName());
                    logger.severe(e.toString());
                }
            }
        }

        scanner.close();
    }
}