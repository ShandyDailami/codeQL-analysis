import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_16683_FileScanner_A03 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        logger.info("Current directory: " + currentDir);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory to search:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        logger.info("File found: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        logger.warning("Directory found: " + file.getAbsolutePath());
                    }
                }
            } else {
                logger.warning("No files or directories found in the directory");
            }
        } else {
            logger.warning("Directory does not exist or is not a directory");
        }
    }
}