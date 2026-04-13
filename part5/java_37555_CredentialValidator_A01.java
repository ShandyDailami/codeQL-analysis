import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;

public class java_37555_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(Subject subject, String credentials) throws LoginException {
        // This method is called to validate the user's credentials.
        // For simplicity, we're just checking if the credentials are all letters.
        // In a real application, you would also want to hash the credentials and compare them with the hashed version stored in the database.
        if (credentials.matches("[a-zA-Z]+")) {
            return true;
        } else {
            return false;
        }
    }
}