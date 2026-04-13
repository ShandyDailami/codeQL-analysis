import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_10802_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());
    
    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            logger.log(Level.SEVERE, "Directory does not exist: {0}", directoryPath);
            return;
        }

        if (!directory.isDirectory()) {
            logger.log(Level.SEVERE, "{0} is not a directory", directoryPath);
            return;
        }

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                File file = new File(filePath);
                if (file.exists() && !file.isFile()) {
                    logger.log(Level.SEVERE, "{0} is not a file", filePath);
                } else {
                    logger.info("Found file: {0}", filePath);
                    // Add real code here, for example:
                    // process file, reading and printing to console
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNext()) {
                            logger.info("Reading line: {0}", fileScanner.nextLine());
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "File not found: {0}", directoryPath, ex);
        }
    }
}