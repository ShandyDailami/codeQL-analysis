import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_05046_CredentialValidator_A07 {

    // This method validates if the password is strong enough
    public boolean authenticate(String password) throws CredentialException, LoginException {
        // The password should be at least 8 characters long, contain at least one uppercase letter,
        // one lowercase letter, one digit, and one special character.
        if (password.length() < 8) {
            throw new CredentialException("Password is too short. It should be at least 8 characters long.");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new CredentialException("Password should contain at least one digit.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new CredentialException("Password should contain at least one lowercase letter.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new CredentialException("Password should contain at least one uppercase letter.");
        }
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new CredentialException("Password should contain at least one of the symbols $@#^&*().");
        }
        return true;
    }

}