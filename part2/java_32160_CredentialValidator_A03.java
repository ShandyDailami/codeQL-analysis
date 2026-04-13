import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import javax.security.auth.message.AuthException;
import javax.security.auth.password.PasswordAuthenticationMechanism;
import javax.security.auth.password.PasswordState;
import javax.security.auth.password.callback.Callback;
import javax.security.auth.password.callback.CallbackHandler;
import javax.security.auth.password.PasswordAuthorizer;

public class java_32160_CredentialValidator_A03 implements PasswordAuthorizer {

    @Override
    public boolean authenticate(Subject subject, String username,
            String password) throws LoginException, AuthException {
        System.out.println("Validating user: " + username);
        return validatePassword(username, password);
    }

    @Override
    public boolean authorize(Subject subject, String role) throws LoginException, AuthException {
        System.out.println("Authorizing user: " + subject.getPrincipal());
        return true; // allow access if role is null
    }

    private boolean validatePassword(String username, String password) {
        // Validate password here...
        // This is a simple example, replace with actual validation logic
        return password.equals("password");
    }

    public static void main(String[] args) {
        CustomValidator validator = new CustomValidator();

        // Test authentication
        try {
            validator.authenticate(null, "testuser", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test authorization
        try {
            validator.authorize(null, "testuser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}