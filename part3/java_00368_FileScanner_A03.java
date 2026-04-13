import java.io.File;
import java.util.Scanner;

public class java_00368_FileScanner_A03 {
    private final String directoryPath;

    public java_00368_FileScanner_A03(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scan() {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isFileSafe(file)) {
                        System.out.println("File: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        scanDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSafe(file)) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private boolean isFileSafe(File file) {
        // Implement security-sensitive operations here, e.g., file path length limit, file type, etc.
        // For simplicity, we assume this method always returns true for security-sensitive operations.
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        SecureFileScanner scannerImpl = new SecureFileScanner(directoryPath);
        scannerImpl.scan();
        scanner.close();
    }
}