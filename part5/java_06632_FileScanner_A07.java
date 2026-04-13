import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_06632_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        // Provide the directory from which to start the scan
        File startDir = new File("/path/to/start/directory");

        // Create a FileFilter to only accept directories
        FileFilter dirFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // Recursively scan the directory and its subdirectories
        scanDirectory(startDir, dirFilter);
    }

    private static void scanDirectory(File directory, FileFilter filter) throws IOException {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, filter);
                } else {
                    // Perform security-sensitive operation here (e.g., reading the file)
                    // ...
                }
            }
        }
    }
}