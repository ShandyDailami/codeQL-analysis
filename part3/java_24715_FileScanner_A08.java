import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_24715_FileScanner_A08 {

    public static void main(String[] args) {
        // Specify the directory to scan
        String dirPath = "/path/to/dir";

        // Use a FileFilter to accept only directories
        FileFilter dirFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // Use a FileFilter for files with the .txt extension
        FileFilter txtFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".txt");
            }
        };

        // Use a FilenameFilter for files with a specific extension
        FilenameFilter specificFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return Pattern.matches(".*\\.txt$", name);
            }
        };

        // Scan the directory
        File dir = new File(dirPath);
        printFiles(dir.listFiles(dirFilter), "dirs");
        printFiles(dir.listFiles(txtFilter), "txt files");
        printFiles(dir.listFiles(specificFilter), "specific files");
    }

    private static void printFiles(File[] files, String type) {
        System.out.printf("=== Listing %s ===\n", type);
        if (files == null) {
            System.out.println("No " + type + " found.");
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else {
                System.out.printf("Skip directory: %s\n", file.getAbsolutePath());
            }
        }
    }
}