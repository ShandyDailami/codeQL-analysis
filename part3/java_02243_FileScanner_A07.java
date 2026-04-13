import java.io.File;
import java.io.FileFilter;
import java.util.logging.Logger;

public class java_02243_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(AuthFailureScanner.class.getName());

    private File rootDirectory;

    public java_02243_FileScanner_A07(String rootDirectoryPath) {
        rootDirectory = new File(rootDirectoryPath);
    }

    public void scan(String extension) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(extension.toLowerCase());
            }
        };
        scan(rootDirectory, filter);
    }

    private void scan(File directory, FileFilter filter) {
        File[] foundFiles = directory.listFiles(filter);
        if (foundFiles == null) {
            return;
        }
        for (File file : foundFiles) {
            if (file.isFile()) {
                logger.info("Found file: " + file.getAbsolutePath());
                // Add code here to handle security-sensitive operations related to A07_AuthFailure
                // For example, checking if a file is executable and has sufficient permissions
            } else if (file.isDirectory()) {
                logger.info("Found directory: " + file.getAbsolutePath());
                scan(file, filter);
            }
        }
    }

    public static void main(String[] args) {
        AuthFailureScanner scanner = new AuthFailureScanner("/path/to/directory");
        scanner.scan(".txt");
    }
}