import java.security.Permission;
import java.security.SecurityManager;
import java.security.Guard;

public class java_07424_CredentialValidator_A03 implements SecurityManager {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Guard getGuard(Permission[] permissions) {
        return new Guard() {
            public boolean implies(Permission p) {
                return false;
            }
        };
    }

    public Guard getGuard() {
        return getGuard(new Permission[0]);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean checkUsername(String username) {
        return this.username.equals(username);
    }
}

public class CredentialValidator {
    public void validate(String username, String password) {
        MySecurityManager securityManager = new MySecurityManager();
        securityManager.setUsername(username);
        securityManager.setPassword(password);

        if (!securityManager.checkUsername(username) || !securityManager.checkPassword(password)) {
            throw new SecurityException("Invalid username or password");
        }
    }
}