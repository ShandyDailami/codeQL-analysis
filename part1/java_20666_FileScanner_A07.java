import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_20666_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt";

        try (FileScanner fileScanner = new FileScanner(new File(directoryPath))) {
            fileScanner.filter(f -> f.isFile() && f.getName().endsWith(extension));
            fileScanner.forEach(file -> logger.log(Level.INFO, "Found file: {0}", file.getAbsolutePath()));
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "File not found: {0}", ex.getLocalizedMessage());
        }
    }
}