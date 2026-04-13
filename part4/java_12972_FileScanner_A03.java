import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_12972_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File(".");

        Logger logger = Logger.getLogger(FileScannerExample.class.getName());
        try (Scanner scanner = new Scanner(file.getAbsoluteFile())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                logger.log(Level.INFO, line);
            }
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "File not found", ex);
        }
    }
}