import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Permission;
import java.security.SecurityManager;

public class java_22877_FileScanner_A03 {
    private static final SecurityManager securityManager = new SecurityManager() {
        @Override
        public void checkPermission(Permission perm) {
            // Do nothing, just allow everything.
        }

        @Override
        public void checkActions(String actions) {
            // Do nothing, just allow everything.
        }
    };

    public static void main(String[] args) {
        String directory = "src";

        File file = new File(directory);
        FileScanner scanner = new FileScanner();
        scanner.scan(file, ".*\\.java$");
    }

    public void scan(File file, String pattern) {
        if (securityManager.checkPathPermission(file.toPath(), file) == null) {
            try {
                FileScan(file, pattern);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void FileScan(File file, String pattern) throws IOException {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || (pathname.getName().endsWith(".java") && pathname.getName().matches(pattern));
            }
        });

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    scan(f, pattern);
                } else {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}