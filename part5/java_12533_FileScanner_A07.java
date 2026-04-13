import java.io.*;
import java.security.*;

public class java_12533_FileScanner_A07 {

    public static void main(String[] args) throws Exception {

        // Create a SecurityManager
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public boolean getSecurityPermission(Permission perm) {
                // Allow all permissions
                return true;
            }

            @Override
            public void checkPermission(Permission perm, String className) throws SecurityException {
                // Allow all permissions
                return;
            }
        };

        // Set the security manager on the current thread
        Thread.currentThread().setSecurityManager(securityManager);

        // Get the user's home directory
        File homeDir = new File(System.getProperty("user.home"));

        // Create a FileFilter that only allows directories
        FileFilter dirFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // Use FileScanner to list directories in the home directory
        FileScanner scanner = new FileScanner(homeDir, dirFilter, true);

        // Use a FileVisitor to print each directory
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        };

        // Use the FileVisitor to list directories in the home directory
        try {
            FileUtils.walkFileTree(homeDir, dirFilter, Integer.MAX_VALUE, fileVisitor);
        } finally {
            scanner.close();
        }
    }
}