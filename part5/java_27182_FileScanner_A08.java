import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27182_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner to scan for files
        FileScanner scanner = new FileScanner();

        // Set the directory to scan
        scanner.setDirectory("/path/to/directory");

        // Scan the directory
        File[] files = scanner.scan();

        // Print the file names
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }

    // FileScanner class is not a standard class and it is not a part of Java's standard library
    // Here is a simple implementation of a file scanner, it does not include security-sensitive operations
    // and it's very basic
    private static class FileScanner {
        private String directory;

        public void setDirectory(String directory) {
            this.directory = directory;
        }

        public File[] scan() throws FileNotFoundException {
            // Assuming that the scan method returns a list of files
            // This is not real, it's just a mock implementation
            return new File(directory).listFiles();
        }

        public void close() {
            // Nothing to do here
        }
    }
}