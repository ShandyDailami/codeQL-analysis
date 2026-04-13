import java.io.*;

public class java_19286_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new java.security.AccessControl() {
                public void checkPermission(java.security.Permission permission) throws SecurityException {
                    if (permission instanceof java.io.FilePermission) {
                        java.io.File file = (java.io.File) permission.getSubject();
                        if (file.isDirectory() && file.getAbsolutePath().equals(file.getCanonicalPath())) {
                            throw new SecurityException("Operation denied: " + permission);
                        }
                    }
                }
            });
        }
        printDirectory(file);
    }

    private static void printDirectory(File file) throws IOException {
        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            if (f.isDirectory()) {
                printDirectory(f);
            } else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}