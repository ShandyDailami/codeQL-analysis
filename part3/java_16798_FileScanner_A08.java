import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16798_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner to scan the current directory.
        FileScanner scanner = new FileScanner();

        // Get the current directory.
        File currentDirectory = new File(".");

        // Scan the current directory.
        scanner.scanDirectory(currentDirectory);

        // Print the results.
        scanner.printResults();
    }

    // Implement FileScanner.
    static class FileScanner {
        private File[] files;
        private long totalSize;

        public void scanDirectory(File directory) throws FileNotFoundException {
            files = directory.listFiles();
            totalSize = 0;

            for (File file : files) {
                if (file.isFile()) {
                    totalSize += file.length();
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }

        public void printResults() {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                }
            }
            System.out.println("Total size: " + totalSize + " bytes");
        }
    }
}