import java.security.Permission;
import java.security.SecurityManager;
import java.security.Subject;

public class java_18949_SessionManager_A01 {

    private SecurityManager securityManager;

    public java_18949_SessionManager_A01() {
        securityManager = System.getSecurityManager();
    }

    public void login(String username, String password) {
        if (securityManager == null) {
            throw new SecurityException("No SecurityManager in effect");
        }

        Subject subject = new Subject.Public();
        Permission permission = new Permission("act as any user") {
            public void checkPermission() {
                throw new SecurityException("Broken Access Control: Can't act as any user");
            }
        };

        try {
            securityManager.checkPermission(permission);
            subject.add(permission);
            securityManager.setSubject(subject);

            if (!securityManager.login(username, password)) {
                throw new SecurityException("Invalid username or password");
            }
        } finally {
            securityManager.setSubject(null);
            subject.delete(permission);
        }
    }
}