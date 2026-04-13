import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;
import javax.security.auth.message.MessageException;

public class java_01350_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) throws MessageException, LoginException {
        String password = credential.getPassword();

        // Check length
        if (password.length() < 8) {
            return CredentialValidatorResult.failed("Password length should be at least 8 characters");
        }

        // Check for special characters
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return CredentialValidatorResult.failed("Password should contain at least one special character");
        }

        // Check for sequence of characters
        if (password.matches(".*12345.*")) {
            return CredentialValidatorResult.failed("Password should not contain the sequence '12345'");
        }

        return CredentialValidatorResult.success();
    }
}