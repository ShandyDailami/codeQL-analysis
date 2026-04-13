import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

public class java_29846_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_29846_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) throws CredentialNotFoundException, LoginException {
        String storedPassword = this.credentials.get(user);

        if (storedPassword == null) {
            throw new CredentialNotFoundException("User not found");
        }

        if (!storedPassword.equals(password)) {
            throw new LoginException("Invalid password");
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        try {
            validator.validateCredentials("user1", "password1");
            System.out.println("Valid credentials");
        } catch (CredentialNotFoundException | LoginException e) {
            System.out.println("Invalid credentials: " + e.getMessage());
        }
    }
}