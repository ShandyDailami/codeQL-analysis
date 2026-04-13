import java.util.Base64;
import java.util.Map;

public class java_36109_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_36109_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate(Map<String, String> credentials) {
        String providedUsername = credentials.get("username");
        String providedPassword = credentials.get("password");

        // In a real-world application, you'd likely want to hash and salt the passwords
        // for security reasons, as in A01_BrokenAccessControl.
        // In this example, we're comparing the plain text passwords.

        if (this.username.equals(providedUsername) && this.password.equals(providedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}