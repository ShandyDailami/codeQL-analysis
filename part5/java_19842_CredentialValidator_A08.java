import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_19842_CredentialValidator_A08 implements CredentialValidator {

    private final String hardCodedPassword = "password"; // Hard-coded password

    @Override
    public String validate(String arg0) throws CredentialException, InvalidCredentialException {
        // Check if input password matches hard-coded password
        if (arg0.equals(hardCodedPassword)) {
            return arg0;
        } else {
            throw new InvalidCredentialException("Invalid password");
        }
    }

    @Override
    public boolean supports(String arg0) {
        return true; // Indicates this validator is support password validation
    }

}