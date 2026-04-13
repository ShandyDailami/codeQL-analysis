import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_15489_FileScanner_A08 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/test.txt");

            if (file.exists()) {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    logger.info("Processing line: " + line);
                    // In real use case, perform some security-sensitive operation.
                    // This is just a placeholder for now.
                }

                scanner.close();

            } else {
                logger.warning("File does not exist: " + file.getAbsolutePath());
            }

        } catch (Exception e) {
            logger.warning("Error occurred while processing file: " + e.getMessage());
        }
    }
}