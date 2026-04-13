import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsufficientPermissionException;

public class java_41058_FileScanner_A08 {
    // Define a static SecurityManager for checking permissions
    private static class SecurityManager extends java.security.SecurityManager {
        private Permission permission = new Permission("A08_IntegrityFailure");

        public void checkPermission(Permission perm) throws UnsufficientPermissionException {
            if (!(perm instanceof A08_IntegrityFailure)) {
                throw new UnsufficientPermissionException("Permission Denied");
            }
        }
    }

    public static void main(String[] args) {
        // Set up the SecurityManager
        SecurityManager sm = new SecurityManager();
        System.setSecurityManager(sm);

        // Create a new file
        File file = new File(".");

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }

        // Print all file names in the current directory
        String[] files = file.list();
        for (String string : files) {
            System.out.println(string);
        }
    }
}