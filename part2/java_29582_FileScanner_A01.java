import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_29582_FileScanner_A01 {

    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    private File directory;
    private String extension;

    public java_29582_FileScanner_A01(File directory, String extension) {
        this.directory = directory;
        this.extension = extension;
    }

    public void scan() {
        File[] foundFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (foundFiles == null) {
            logger.log(Level.SEVERE, "Directory not found: {0}", directory);
            return;
        }

        for (File file : foundFiles) {
            logger.log(Level.INFO, "Found file: {0}", file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        File directory = new File(".");
        String extension = "txt";

        FileScanner scanner = new FileScanner(directory, extension);
        scanner.scan();
    }
}