import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_01688_FileScanner_A01 {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.start();
    }

    private static class FileScanner {

        private static final String DIR_PATH = "src/main/java";

        private void start() {
            File file = new File(DIR_PATH);
            if (file.isDirectory()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        logger.info("Line read: " + line);
                    }
                } catch (FileNotFoundException e) {
                    logger.severe("File not found: " + e.getMessage());
                }
            } else {
                logger.warning("Path is not a directory: " + DIR_PATH);
            }
        }
    }
}