import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_03044_FileScanner_A01 {

    public static void main(String[] args) {
        File root = new File("."); // The current directory

        // Define the filter to only include directories
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        };

        // Scan the directory
        scanDirectory(root, filter);
    }

    private static void scanDirectory(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            // Print the list of files
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));

            // Recursively scan the subdirectories
            Arrays.stream(files).forEach(file -> scanDirectory(file, filter));
        }
    }
}