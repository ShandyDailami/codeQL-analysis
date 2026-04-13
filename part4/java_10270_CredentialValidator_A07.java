import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_10270_CredentialValidator_A07 {
    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            System.out.println("No security manager found.");
            System.exit(1);
        }
        
        try {
            PrivilegedAction<Void> action = new PrivilegedAction<Void>() {
                public Void run() {
                    validateCredentials("username", "password");
                    return null;
                }
            };
            securityManager.doPrivileged(action);
        } catch (Exception e) {
            System.out.println("Failed to validate credentials: " + e.getMessage());
        }
    }

    public static void validateCredentials(String username, String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Valid credentials");
        } else {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                Permission permission = new Permission("A07_AuthFailure");
                try {
                    securityManager.checkPermission(permission);
                    System.out.println("Permission granted");
                } catch (SecurityException se) {
                    System.out.println("Permission denied");
                }
            }
        }
    }
}