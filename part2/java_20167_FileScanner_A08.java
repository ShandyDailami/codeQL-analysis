import java.io.File;
import java.io.FilenameFilter;

public class java_20167_FileScanner_A08 {
    // File name filter for the scanner.
    private static final FilenameFilter FILE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            // Check if the name matches the target file.
            return name.equals("targetFile.txt");
        }
    };

    public static void main(String[] args) {
        // Start the scan from the current directory.
        scanDirectory(".", FILE_FILTER);
    }

    /**
     * Recursively scan a directory for files that match a filter.
     *
     * @param directory the directory to start the scan from.
     * @param filter    the filter to match the files against.
     */
    public static void scanDirectory(String directory, FilenameFilter filter) {
        File file = new File(directory);
        File[] listFiles = file.listFiles(filter);
        for (File f : listFiles) {
            if (f.isFile()) {
                // File found, do something with it.
                System.out.println("Found target file: " + f.getAbsolutePath());
            } else if (f.isDirectory()) {
                // Directory found, recursively scan it.
                scanDirectory(f.getAbsolutePath(), filter);
            }
        }
    }
}