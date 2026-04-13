import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.AccessControlException;

public class java_00923_FileScanner_A07 {

    public static void main(String[] args) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            try {
                sm.checkPermission(new FilePermission("file:"));
                System.out.println("Permission granted.");
            } catch (AccessControlException e) {
                System.out.println("Permission denied.");
            }
        } else {
            System.out.println("System.getSecurityManager() is null.");
        }
    }
}