import java.io.*;

public class java_21199_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory to start scanning
        File directory = new File("path_to_directory");

        // Scan the directory
        scanDirectory(directory, true);
    }

    private static void scanDirectory(File directory, boolean recursive) {
        // Get a list of all files in the directory
        File[] files = directory.listFiles();

        // If there are no files, stop recursion
        if (files == null) {
            return;
        }

        // For each file in the directory
        for (File file : files) {
            // If this is a directory and recursive is set, recursively scan the directory
            if (file.isDirectory() && recursive) {
                scanDirectory(file, true);
            }

            // If this is a file, print its name
            else if (file.isFile()) {
                System.out.println(file.getPath());
            }
        }
    }
}