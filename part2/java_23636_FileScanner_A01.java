import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_23636_FileScanner_A01 {

    private static final Logger logger = Logger.getLogger(SecurityScanner.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory path:");
        String dirPath = scanner.nextLine();

        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".java")) {
                            logger.info("Reading file: " + fileName);
                            readFile(file);
                        }
                    } else if (file.isDirectory()) {
                        logger.info("Entering directory: " + file.getPath());
                        scanDirectory(file);
                    }
                }
            } else {
                logger.info("No files or directories found in the specified path.");
            }
        } finally {
            scanner.close();
        }
    }

    private static void scanDirectory(File dir) {
        try {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".java")) {
                            logger.info("Reading file: " + fileName);
                            readFile(file);
                        }
                    } else if (file.isDirectory()) {
                        logger.info("Entering directory: " + file.getPath());
                        scanDirectory(file);
                    }
                }
            }
        } catch (Exception e) {
            logger.severe("An error occurred while scanning the directory: " + dir.getPath());
            logger.severe(e.toString());
        }
    }

    private static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                logger.info(line);
            }
            scanner.close();
        } catch (Exception e) {
            logger.severe("An error occurred while reading the file: " + file.getName());
            logger.severe(e.toString());
        }
    }
}