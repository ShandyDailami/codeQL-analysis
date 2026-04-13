import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21459_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new FileScanner instance to scan for files
        FileScanner scanner = new FileScanner();

        // Use the scanner to list all files in the current directory
        scanner.scanDirectory(".", true);

        // Print the number of files found
        System.out.println("Found " + scanner.getFileCount() + " files.");
    }

    public static class FileScanner {
        private int fileCount;

        public void scanDirectory(String directory, boolean recursive) {
            File rootDirectory = new File(directory);
            File[] directoryContents = rootDirectory.listFiles();

            // Ensure we're not trying to access null or empty arrays
            if (directoryContents == null) {
                return;
            }

            // Scan each file in the directory
            for (File file : directoryContents) {
                if (file.isFile()) {
                    fileCount++;
                    System.out.println("Found file: " + file.getName());
                } else if (file.isDirectory() && recursive) {
                    scanDirectory(file.getPath(), recursive);
                }
            }
        }

        public int getFileCount() {
            return fileCount;
        }
    }
}