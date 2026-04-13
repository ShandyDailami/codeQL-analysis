import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;

public class java_19377_CredentialValidator_A03 {

    public void validate(String username, String password) throws CredentialException, LoginException, CredentialNotFoundException {
        // This is a placeholder for real login functionality.
        // Normally, you would use a library like Bcrypt or Java's in-built Security class to validate passwords.

        if (username.equals("admin") && password.equals("password")) {
            throw new CredentialNotFoundException("Invalid Credentials");
        }
        throw new CredentialException("Invalid Credentials");
    }
}