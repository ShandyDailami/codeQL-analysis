import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;

public class java_11362_FileScanner_A01 {

    // This is a file filter that only accepts directories
    private static final FileFilter directoryFilter = new FileFilter() {
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    };

    public static void main(String[] args) {
        // Specify the directory to scan
        File directory = new File(".");

        // Use a recursive file scanner to find all directories in the current directory
        FileScanner scanner = new FileScanner(directory, directoryFilter);

        // Start scanning
        scanner.start();
    }

    // FileScanner is a thread-safe class that can start scanning a directory and its subdirectories
    private static class FileScanner extends Thread {
        private File directory;
        private FileFilter filter;

        public java_11362_FileScanner_A01(File directory, FileFilter filter) {
            this.directory = directory;
            this.filter = filter;
        }

        public void run() {
            File[] files = directory.listFiles(filter);
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // If the file is a directory, create a new scanner to scan the subdirectory
                        new FileScanner(file, filter).start();
                    } else {
                        // If the file is a regular file, do something with it
                        // Here, we will just print its name
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}