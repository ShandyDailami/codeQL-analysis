import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.LoginException;
import javax.security.auth.message.LoginMessage;

public class java_26074_CredentialValidator_A03 implements CredentialValidator {
    @Override
    public CredentialValidationResult validate(LoginMessage message) throws LoginException {
        String password = message.getCredential();

        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return CredentialValidationResult.failed("Password is required.");
        }

        // Check if password length is more than 8 characters
        if (password.length() <= 8) {
            return CredentialValidationResult.failed("Password must be more than 8 characters.");
        }

        return CredentialValidationResult.success();
    }
}