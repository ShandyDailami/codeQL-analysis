import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_36726_FileScanner_A08 {

    private List<File> filesToScan = new ArrayList<>();

    public java_36726_FileScanner_A08(String path) {
        File root = new File(path);
        scanDirectory(root);
    }

    private void scanDirectory(File directory) {
        File[] list = directory.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (isSecuritySensitive(file)) {
                    filesToScan.add(file);
                }
            }
        }
    }

    private boolean isSecuritySensitive(File file) {
        // Implement your security-sensitive operation here.
        // For the purpose of this example, let's assume all files that end with ".txt" are security-sensitive.
        return file.getName().toLowerCase().endsWith(".txt");
    }

    public List<File> getFilesToScan() {
        return filesToScan;
    }

    public static void main(String[] args) {
        SecurityAwareFileScanner scanner = new SecurityAwareFileScanner("C:/");
        List<File> securitySensitiveFiles = scanner.getFilesToScan();
        for (File file : securitySensitiveFiles) {
            System.out.println("Found security-sensitive file: " + file.getAbsolutePath());
        }
    }
}