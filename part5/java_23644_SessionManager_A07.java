import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;

public class java_23644_SessionManager_A07 {
    private static final String USER_DN = "user";
    private static final String USER_PWD = "password";

    private static final String ADMIN_DN = "admin";
    private static final String ADMIN_PWD = "password";

    private boolean isUserAllowed(String dn) throws Exception {
        // Load the user's credentials from a secure source
        // This is just a placeholder, actual implementation should use secure method to load user's credentials
        return dn.equals(USER_DN) && USER_PWD.equals(USER_PWD);
    }

    private boolean isAdminAllowed(String dn) throws Exception {
        // Load the admin's credentials from a secure source
        // This is just a placeholder, actual implementation should use secure method to load admin's credentials
        return dn.equals(ADMIN_DN) && ADMIN_PWD.equals(ADMIN
        m.equals(ADMIN_PWD);
    }

    public void secureOperation(Runnable operation) {
        try {
            if (isUserAllowed(Thread.currentThread().getSecurityContext().getSubject().getPrincipal().toString())) {
                operation.run();
            } else if (isAdminAllowed(Thread.currentThread().getSecurityContext().getSubject().getPrincipal().toString())) {
                // Continue with admin privileges
                operation.run();
            } else {
                throw new Exception("Access denied!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}