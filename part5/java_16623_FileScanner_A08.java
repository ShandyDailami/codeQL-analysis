import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_16623_FileScanner_A08 {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.start();
    }
}

class FileScanner {

    public java_16623_FileScanner_A08() {
        logger.info("Initializing FileScanner");
    }

    public void start() {
        File directory = new File(".");
        String[] extensions = new String[]{"txt"};
        getFilesWithExtensions(directory, extensions);
    }

    private void getFilesWithExtensions(File directory, String[] extensions) {
        File[] files = directory.listFiles((dir, name) -> Arrays.asList(extensions).contains(getFileExtension(name)));
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file);
                } else if (file.isDirectory()) {
                    getFilesWithExtensions(file, extensions);
                }
            }
        }
    }

    private String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    private void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                logger.info("Line " + lineNumber + ": " + line);
            }
        } catch (Exception e) {
            logger.warning("Could not process file: " + file.getAbsolutePath());
        }
    }
}