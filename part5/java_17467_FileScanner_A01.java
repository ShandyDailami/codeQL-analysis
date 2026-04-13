import java.io.File;
import java.util.Scanner;

public class java_17467_FileScanner_A01 {
    private Scanner scanner;

    public java_17467_FileScanner_A01(String filePath) {
        this.scanner = new Scanner(System.in);
        File file = new File(filePath);

        // Ensure file exists and can be read
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("File not found or not readable.");
        }

        // Ensure the file is a directory (not a file)
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("File is not a directory.");
        }

        // Ensure the user has sufficient permissions to read the file
        if (!file.canRead()) {
            throw new SecurityException("Insufficient permissions to read the file.");
        }

        // Ensure the user has sufficient permissions to list the files in the directory
        if (!file.canRead()) {
            throw new SecurityException("Insufficient permissions to list the files in the directory.");
        }
    }

    public void scanDirectory() {
        File[] files = this.scanner.next().getFiles();
        for (File file : files) {
            // Perform security-sensitive operations here
            // e.g. check if the file is executable
            if (!file.canExecute()) {
                System.out.println("Security alert: File " + file.getName() + " is executable.");
            }

            // Recursively scan subdirectories
            if (file.isDirectory()) {
                scanDirectory();
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        scanner.scanDirectory();
    }
}