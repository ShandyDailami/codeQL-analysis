import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_14078_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) {
        // Create a File instance representing the directory to scan
        File directory = new File(".");

        // Initialize a Scanner to read the directory
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                logger.info("Reading file: " + file.getName());
                readFile(file);
            }
        } catch (FileNotFoundException e) {
            logger.severe("Failed to read directory: " + e.getMessage());
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                logger.info("Line in file: " + line);
                // Do something with the line, e.g., print it
            }
        } catch (FileNotFoundException e) {
            logger.severe("Failed to read file: " + e.getMessage());
        }
    }
}