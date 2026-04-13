import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_25790_FileScanner_A01 {

    public static class BrokenAccess extends SecurityException {
        public java_25790_FileScanner_A01(String s) {
            super(s);
        }
    }

    public static class FileScanner {
        private Set<File> files = new HashSet<>();

        public java_25790_FileScanner_A01(String path) {
            File file = new File(path);
            if (file.canRead()) {
                scan(file);
            } else {
                throw new BrokenAccess("Can't read file: " + path);
            }
        }

        private void scan(File file) {
            if (file.isDirectory()) {
                File[] childFiles = file.listFiles();
                if (childFiles != null) {
                    for (File childFile : childFiles) {
                        scan(childFile);
                    }
                }
            } else if (file.isFile()) {
                files.add(file);
            } else {
                throw new BrokenAccess("Can't read directory: " + file.getPath());
            }
        }

        public Set<File> getFiles() {
            return files;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path:");
        String path = scanner.nextLine();
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                throw new SecurityException("Broken permission: " + perm);
            }
        };
        System.setSecurityManager(securityManager);
        try {
            FileScanner scanner = new FileScanner(path);
            Set<File> files = scanner.getFiles();
            for (File file : files) {
                System.out.println("Found file: " + file.getPath());
            }
        } catch (BrokenAccess e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}