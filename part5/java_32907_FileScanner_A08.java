import java.io.File;
import java.util.Arrays;

public class java_32907_FileScanner_A08 {
    public static void main(String[] args) {
        // Change this to the directory you want to scan
        String directory = "/path/to/directory";

        File root = new File(directory);

        // Traverse the directory tree
        scanDirectory(root);
    }

    private static void scanDirectory(File directory) {
        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if there are any files
        if (files == null) {
            return;
        }

        // Loop through each file
        for (File file : files) {
            // If the file is a directory, recursively scan it
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                // If the file is a regular file, print its name
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}