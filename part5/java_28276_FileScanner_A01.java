import java.io.*;

public class java_28276_FileScanner_A01 {
    private String directoryPath;

    public java_28276_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);

        // Check if directory exists and is readable
        if (!directory.exists() || !directory.canRead()) {
            System.out.println("Directory does not exist or is not readable.");
            return;
        }

        // Recursively scan directory
        scanDirectoryRecursively(directory);
    }

    private void scanDirectoryRecursively(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If file is a directory, recursively scan it
                    scanDirectoryRecursively(file);
                } else if (file.isFile() && isFileAccessAllowed(file)) {
                    // If file is a file and access is allowed, print its name
                    System.out.println(file.getName());
                }
            }
        }
    }

    // Sample method to check if a file should be scanned
    private boolean isFileAccessAllowed(File file) {
        // Place your security-sensitive operations here.
        // For the purpose of this example, we will always allow access.
        return true;
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        scanner.scanDirectory();
    }
}