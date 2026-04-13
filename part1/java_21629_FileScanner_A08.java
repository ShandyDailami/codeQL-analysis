import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_21629_FileScanner_A08 {
    private static final Logger logger = Logger.getLogger(FileScannerExample.class.getName());

    public static void main(String[] args) {
        File file = new File("example.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            processLine(line);
        }

        scanner.close();
    }

    private static void processLine(String line) {
        // Add your security-sensitive operations here.
        // For example, checking for a certain pattern in the line.

        logger.log(Level.INFO, "Processing line: {0}", line);
    }
}