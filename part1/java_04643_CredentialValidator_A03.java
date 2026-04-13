import javax.security.auth.CredentialValidationResult;
import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.Subject;

public class java_04643_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Subject subject, Object credentials) {
        String password = (String) credentials;
        
        // Check if the password is too short
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password is too short");
        }

        // Check if the password contains a digit
        if (!password.matches(".*\\d.*")) {
            return CredentialValidationResult.failed("Password should contain at least one digit");
        }

        // Check if the password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return CredentialValidationResult.failed("Password should contain at least one lowercase letter");
        }

        // Check if the password contains an uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return CredentialValidationResult.failed("Password should contain at least one uppercase letter");
        }

        // Check if the password contains a special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return CredentialValidationResult.failed("Password should contain at least one special character");
        }

        // If the password is valid, return successful validation
        return CredentialValidationResult.success();
    }

}