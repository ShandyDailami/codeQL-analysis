import java.io.File;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class java_16240_FileScanner_A07 {

    private static final Logger LOGGER = Logger.getLogger(SecureFileScanner.class.getName());
    private static final Pattern FILE_PATTERN = Pattern.compile(".*\\.txt$");

    public static void main(String[] args) {
        if (args.length == 0) {
            LOGGER.warning("No directory provided. Using current directory.");
            args = new String[]{"."};
        }
        FileScanner scanner = new FileScanner(args[0]);
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            if (isFileAllowed(file)) {
                LOGGER.info("File: " + file.getAbsolutePath() + " matched pattern: " + FILE_PATTERN);
            }
        }
    }

    private static boolean isFileAllowed(File file) {
        return FILE_PATTERN.matcher(file.getName()).matches();
    }
}