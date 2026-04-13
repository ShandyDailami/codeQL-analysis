import java.security.GeneralSecurityException;
import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractLoginModule;

public class java_07038_CredentialValidator_A07 extends AbstractLoginModule {

    @Override
    public CredentialValidationResult validate(Subject subject, Object credentials) {
        String password = (String) credentials;

        // Check if password is too weak
        if (password == null || password.length() < 8) {
            return CredentialValidationResult.failed("Password must be at least 8 characters long.");
        }

        // Check if password contains uppercase letter, lowercase letter, digit, and special character
        if (!(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$"))) {
            return CredentialValidationResult.failed("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }

        // If password is valid, return success
        return CredentialValidationResult.success();
    }
}