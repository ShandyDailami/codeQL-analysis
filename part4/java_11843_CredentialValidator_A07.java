import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialInvalidException;
import javax.security.auth.InvalidCredentialException;

public class java_11843_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public String validate(String credentialId) throws CredentialInvalidException {
        // This is a simple validation. In a real-world application, you would need
        // to perform additional checks such as checking the password strength, 
        // comparing the entered password with the stored password, and validating 
        // the user's credentials.

        if ("username".equals(credentialId) && "password".equals(credentialId)) {
            return "user";
        } else {
            throw new InvalidCredentialException("Invalid username or password.");
        }
    }

    @Override
    public boolean supports(String credentialId) {
        // This method is used to determine if this CredentialValidator supports 
        // the specified credential ID.
        return "username".equals(credentialId) || "password".equals(credentialId);
    }
}