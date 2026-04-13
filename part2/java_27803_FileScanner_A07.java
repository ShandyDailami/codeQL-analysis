import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_27803_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(VanillaFileScanner.class.getName());

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            logger.severe("Directory does not exist: " + directoryPath);
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            logger.severe("Could not list files in directory: " + directoryPath);
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                printFileContents(file);
            }
        }
    }

    private static void printFileContents(File file) {
        try {
            String content = readFile(file);
            logger.info("File contents: " + content);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error reading file: " + file.getPath(), ex);
        }
    }

    private static String readFile(File file) throws Exception {
        return new String(java.nio.file.Files.readAllBytes(file.toPath()));
    }
}