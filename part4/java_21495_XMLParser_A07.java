import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_21495_XMLParser_A07 {

    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            System.out.println("No security manager found.");
        } else {
            securityManager.setSecurityAction("save", new PrivilegedAction<Void>() {
                public Void run() {
                    System.out.println("Security manager found. Saving state...");
                    return null;
                }
            });
            System.out.println("Security manager found.");
        }
        
        try {
            parse();
        } catch (AccessControlException e) {
            System.out.println("Access denied.");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public static void parse() throws AccessControlException {
        throw new AccessControlException("Access denied");
    }

}