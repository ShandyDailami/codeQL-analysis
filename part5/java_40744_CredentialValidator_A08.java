import javax.security.auth.CredentialValidationResult;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;

public class java_40744_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws LoginException {
        String password = credential.getPassword();

        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return CredentialValidationResult.failed("No password provided");
        }

        // Check if password is at least 8 characters long and contains a digit
        if (password.length() < 8 || !password.matches(".*\\d.*")) {
            return CredentialValidationResult.failed("Password should be at least 8 characters long and contain a digit");
        }

        // If password passes all checks, return success
        return CredentialValidationResult.success();
    }
}