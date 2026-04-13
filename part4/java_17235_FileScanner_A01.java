import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_17235_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            logger.info("Scanning files in directory: " + dirPath);

            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        logger.info("Found file: " + file.getName());
                    } else {
                        logger.warning("Skipping non-readable file: " + file.getName());
                    }
                }
            } else {
                logger.warning("Failed to list files in directory: " + dirPath);
            }
        } else {
            logger.warning("Directory not found: " + dirPath);
        }

        scanner.close();
    }
}