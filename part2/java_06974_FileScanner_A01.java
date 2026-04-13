import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_06974_FileScanner_A01 {

    private final File rootDirectory;

    public java_06974_FileScanner_A01(String rootDirectoryPath) {
        Objects.requireNonNull(rootDirectoryPath);
        rootDirectory = new File(rootDirectoryPath);
        if (!rootDirectory.exists()) {
            throw new IllegalArgumentException("Root directory does not exist: " + rootDirectoryPath);
        }
    }

    public void scan() {
        scan(rootDirectory);
    }

    private void scan(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file);
                } else if (file.isFile()) {
                    processFile(file);
                }
            }
        }
    }

    private void processFile(File file) {
        // This method is meant to be overridden in order to process files differently.
        // For example, you might use a logging framework or a simple console application.
        System.out.println("Processing file: " + file.getAbsolutePath());
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(".");
        scanner.scan();
    }
}