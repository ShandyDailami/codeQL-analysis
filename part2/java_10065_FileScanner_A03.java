import java.io.File;
import java.io.FileFilter;

public class java_10065_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        FileScanner scanner = new FileScanner(directory);

        // Iterate over all files in the directory
        for (File file : scanner.getFiles()) {
            // Check if file is a directory
            if (file.isDirectory()) {
                // Skip directory
                continue;
            }

            // Check if file is a Java file
            if (!file.getName().endsWith(".java")) {
                // Skip file
                continue;
            }

            // File is safe to process
            processFile(file);
        }
    }

    private static void processFile(File file) {
        // Implement your security-sensitive operations here
        // ...
    }

    private static class FileScanner implements FileFilter {
        private String directory;

        public java_10065_FileScanner_A03(String directory) {
            this.directory = directory;
        }

        public File[] getFiles() {
            return new File(directory).listFiles(this);
        }

        public boolean accept(File file) {
            return file.isDirectory();
        }
    }
}