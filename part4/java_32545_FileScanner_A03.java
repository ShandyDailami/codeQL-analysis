import java.io.File;
import java.util.Scanner;

public class java_32545_FileScanner_A03 {
    private String targetDirectory;

    public java_32545_FileScanner_A03(String targetDirectory) {
        this.targetDirectory = targetDirectory;
    }

    public void startScan() {
        File root = new File(targetDirectory);
        Scanner s = new Scanner(System.in);

        if (root.exists()) {
            scanDir(root);
        } else {
            System.out.println("Directory does not exist");
        }

        s.close();
    }

    private void scanDir(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDir(file);
                } else if (isFileSafe(file)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            }
        }
    }

    private boolean isFileSafe(File file) {
        // Implement your security-sensitive operations here.
        // For instance, you can check if the file is readable and not executable.
        return file.canRead() && !file.canExecute();
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        scanner.startScan();
    }
}