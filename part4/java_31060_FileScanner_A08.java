import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.security.Permission;
import java.security.SecurityManager;

public class java_31060_FileScanner_A08 {
    private static class MySecurityManager extends SecurityManager {
        private final Permission permission;

        public java_31060_FileScanner_A08(Permission permission) {
            this.permission = permission;
        }

        @Override
        public void checkPermission(Permission perm) {
            if (!permission.equals(perm)) {
                throw new SecurityException("Unable to access file: " + perm.getName());
            }
        }

        @Override
        public void checkDelete(String path) throws SecurityException {
            File file = new File(path);
            if (!file.exists()) {
                throw new SecurityException("File does not exist: " + path);
            }
        }
    }

    public static void main(String[] args) throws IOException, SecurityException {
        String directoryPath = "/path/to/directory";
        String extension = ".txt";

        MySecurityManager securityManager = new MySecurityManager(new Permission("access file: " + directoryPath));
        System.setSecurityManager(securityManager);

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*" + extension);
        Files.newDirectoryStream(Paths.get(directoryPath), matcher).forEach(FileScanner::processFile);
    }

    private static void processFile(Path path) {
        System.out.println("Processing file: " + path.toString());
        // Add your processing code here
    }
}