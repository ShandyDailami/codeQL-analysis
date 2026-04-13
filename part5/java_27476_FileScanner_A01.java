import java.io.*;
import java.security.*;

public class java_27476_FileScanner_A01 {

    // Define the Security Manager
    private final SecurityManager securityManager = new SecurityManager() {
        @Override
        public void checkPermission(Permission perm) {
            if (perm instanceof java.io.FilePermission) {
                java.io.File file = ((java.io.FilePermission) perm).getFile();
                if (!file.canWrite() || !file.canRead()) {
                    throw new SecurityException("FilePermission denied access to: " + file);
                }
            }
            super.checkPermission(perm);
        }
    };

    // Define the File Scanner
    private final FileScanner fileScanner = new FileScanner(securityManager) {
        @Override
        public boolean accept(File pathname) {
            return true; // Accept all files
        }

        @Override
        public boolean visitFile(File file) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        visit(f);
                    }
                }
            } else {
                // Perform security checks
                securityManager.checkPermission(new java.io.FilePermission(file.getAbsolutePath(), "read"));
                securityManager.checkPermission(new java.io.FilePermission(file.getAbsolutePath(), "write"));
            }
            return true;
        }
    };

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.fileScanner.startScanning("/path/to/scan");
    }
}