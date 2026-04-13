import java.io.File;
import java.io.FileNotFoundException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_01533_FileScanner_A07 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan("/path/to/directory");
    }

    private void scan(final String directory) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.runAsPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    try {
                        File file = new File(directory);
                        File[] files = file.listFiles();
                        if (files != null) {
                            for (File f : files) {
                                if (f.isDirectory()) {
                                    scan(f.getAbsolutePath());
                                } else {
                                    // Security sensitive operation
                                    System.out.println("File: " + f.getAbsolutePath());
                                }
                            }
                        }
                        return null;
                    } catch (FileNotFoundException e) {
                        throw new SecurityException("Failed to access file: " + e);
                    }
                }
            });
        } else {
            try {
                File file = new File(directory);
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isDirectory()) {
                            scan(f.getAbsolutePath());
                        } else {
                            // Security sensitive operation
                            System.out.println("File: " + f.getAbsolutePath());
                        }
                    }
                }
            } catch (SecurityException e) {
                System.out.println("Failed to access file: " + e.getMessage());
            }
        }
    }
}