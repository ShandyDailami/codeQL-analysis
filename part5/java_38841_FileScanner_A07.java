import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_38841_FileScanner_A07 {
    private static final Logger LOGGER = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in: " + directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        LOGGER.info("Found file: " + file.getAbsolutePath());
                    } else {
                        LOGGER.warning("File is not readable: " + file.getAbsolutePath());
                    }
                }
            } else {
                LOGGER.warning("No files found in the directory: " + directoryPath);
            }
        } else {
            LOGGER.warning("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }
}