import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.Subject;
import java.util.HashMap;
import java.util.Map;

public class java_35003_CredentialValidator_A01 {
    private final Map<String, String> credentials;
    private final AccessControl accessControl;

    public java_35003_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.accessControl = new AccessControl() {
            @Override
            public boolean checkAccess(Subject subject, Object object) throws AccessDeniedException {
                return false;
            }
        };
        // Add your credentials here.
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            throw new RuntimeException("Invalid username: " + username);
        }
        return expectedPassword.equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        try {
            validator.validateCredentials("user1", "password1");
            System.out.println("Access granted!");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied!");
        }
        try {
            validator.validateCredentials("invalidUser", "password");
            System.out.println("Access granted!");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied!");
        }
    }
}