import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.PasswordAuthentication;

public class java_33646_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public PasswordAuthentication validate(PasswordAuthentication password) {
        String passwordAttempt = password.getPassword().toString();
        if (passwordAttempt.equals("hardcodedPassword")) {
            return password; // Password is correct, return the password
        } else {
            throw new InvalidCredentialException("Invalid password"); // Password is incorrect, throw an exception
        }
    }
}