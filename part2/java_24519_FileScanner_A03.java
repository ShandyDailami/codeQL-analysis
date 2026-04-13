import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_24519_FileScanner_A03 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning(".");
    }

    private void startScanning(String directory) {
        File root = new File(directory);

        File[] files = root.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                processFile(file);
            }
        }

        File[] subDirectories = root.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subDirectories != null) {
            for (File directory : subDirectories) {
                startScanning(directory.getPath());
            }
        }
    }

    private void processFile(File file) {
        // Implement your file processing logic here.
        // For example, you can print the file name to the console.
        System.out.println("Processing file: " + file.getName());
    }
}