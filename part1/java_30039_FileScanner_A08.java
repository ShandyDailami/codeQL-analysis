import java.io.IOException;
import java.nio.file.*;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.AccessControlException;

public class java_30039_FileScanner_A08 {

    private final Path dir;
    private final SecurityManager securityManager;

    public java_30039_FileScanner_A08(Path dir, SecurityManager securityManager) {
        this.dir = dir;
        this.securityManager = securityManager;
    }

    public void scan() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                checkIntegrity(path);
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }

    private void checkIntegrity(Path path) {
        try {
            if (securityManager.checkPermission(new Permission.GroupAction[0])) {
                Files.exists(path);
            } else {
                throw new AccessControlException("Access denied for " + path);
            }
        } catch (IOException e) {
            System.out.println("Error checking integrity of file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Initialize a SecurityManager with a list of trusted classes
        SecurityManager securityManager = new SecurityManager() {
            {
                addPermission(new Permission.GroupAction[] {
                    new Permission.GroupAction("file.delete"),
                    new Permission.GroupAction("file.read"),
                    new Permission.GroupAction("file.write")
                });
            }
        };

        // Initialize the FileScanner
        FileScanner fileScanner = new FileScanner(Paths.get("."), securityManager);

        // Run the scan
        fileScanner.scan();
    }
}