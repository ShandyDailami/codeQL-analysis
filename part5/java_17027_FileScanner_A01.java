import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_17027_FileScanner_A01 {
    private SecurityManager securityManager;

    public java_17027_FileScanner_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                } else {
                    scanFile(file.getPath());
                }
            }
        }
    }

    public void scanFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            int ch;

            while ((ch = reader.read()) != -1) {
                System.out.println(ch);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("Error reading file: " + filePath);
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if (perm instanceof SecurityPermission) {
                    throw new SecurityException("Access denied: " + perm.getClass().getName());
                }
            }

            @Override
            public void checkAccess(java.lang.reflect.MethodCurrentMethod m) {
                try {
                    m.invoke(this, (Object[]) null);
                } catch (Exception e) {
                    throw new SecurityException("Access denied: " + m.getDeclaringClass().getName() + "." + m.getName());
                }
            }
        };

        SecureFileScanner scanner = new SecureFileScanner(securityManager);
        scanner.scanDirectory("/path/to/directory");
    }
}