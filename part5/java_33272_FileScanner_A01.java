import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_33272_FileScanner_A01 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String[] excludedExtensions = {".jpg", ".png"};

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !isFileExcluded(file.getName(), excludedExtensions)) {
                    readFile(file);
                }
            }
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                logger.info(line);
            }
        } catch (FileNotFoundException e) {
            logger.severe("Failed to read file: " + file.getPath());
        }
    }

    private static boolean isFileExcluded(String fileName, String[] excludedExtensions) {
        for (String excludedExtension : excludedExtensions) {
            if (fileName.endsWith(excludedExtension)) {
                return true;
            }
        }
        return false;
    }
}