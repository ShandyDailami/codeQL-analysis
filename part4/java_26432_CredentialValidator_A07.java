import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.message.MessageException;
import javax.security.auth.Credential;

public class java_26432_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public String getName() {
        return "Custom Validator";
    }

    @Override
    public boolean validate(Credential credential) throws MessageException {
        String password = credential.getPassword();
        
        // Check for at least one uppercase, lowercase, digit and special character
        if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$")) {
            return true;
        } else {
            throw new PasswordChangeException("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }
    }

}