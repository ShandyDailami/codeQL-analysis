import java.util.HashMap;
import java.util.Map;

public class java_40775_CredentialValidator_A01 {
    private Map<String, String> credentials;
    private SecurityManager securityManager;

    public java_40775_CredentialValidator_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
        this.credentials = new HashMap<>();

        // Initialize the credentials. This is usually done in a real application
        // where the credentials are stored in a database.
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        // Use the security manager to validate the password
        return securityManager.validatePassword(password);
    }
}