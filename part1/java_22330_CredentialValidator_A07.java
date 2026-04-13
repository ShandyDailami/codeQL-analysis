import javax.security.auth.login.CredentialException;
import javax.security.auth.PasswordValidator;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_22330_CredentialValidator_A07 implements PasswordValidator {

    @Override
    public String validate(Subject subject, String password) throws CredentialException {
        // Validate username and password here (e.g., from a database)
        // If the credentials are not valid, throw an exception
        if (!isValid(subject, password)) {
            throw new CredentialException("Invalid username or password");
        }
        return null; // Success
    }

    private boolean isValid(Subject subject, String password) {
        // Implement validation logic here
        // For this example, we'll just check if the password is not null and contains at least one digit
        return password != null && password.matches(".*\\d.*");
    }
}