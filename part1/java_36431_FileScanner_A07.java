import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_36431_FileScanner_A07 {
    private SecurityManager securityManager;

    public java_36431_FileScanner_A07(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void scan(String directoryPath, final String fileName) {
        File dir = new File(directoryPath);
        if (!dir.exists()) {
            throw new SecurityException("Directory does not exist");
        }

        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().equals(fileName);
            }
        });

        if (files == null || files.length == 0) {
            throw new SecurityException("No file named " + fileName + " found in " + directoryPath);
        }

        securityManager.checkPermission(new Permission("read") {
            @Override
            public Collection<Permission> getActions() {
                return Arrays.asList(new Permission[]{new Permission("read")});
            }
        });

        try {
            Files.readAllBytes(Paths.get(files[0].getPath()));
        } catch (IOException e) {
            throw new SecurityException("Failed to read file " + files[0].getName(), e);
        }
    }

    public static void main(String[] args) {
        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if ("read".equals(perm.getName())) {
                    throw new SecurityException("Permission " + perm.getName() + " denied");
                }
            }
        };
        new SecureFileScanner(sm).scan("/path/to/directory", "file.txt");
    }
}