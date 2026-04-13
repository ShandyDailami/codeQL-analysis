import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_21232_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) {
        logger.info("FileScanner started.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            logger.info("File found: " + file.getName());
                        }
                    } else if (file.isDirectory()) {
                        logger.info("Directory found: " + file.getName());
                    }
                }
            } else {
                logger.warning("No files in the directory.");
            }
        } else {
            logger.warning("Directory not found.");
        }

        logger.info("FileScanner ended.");
    }
}