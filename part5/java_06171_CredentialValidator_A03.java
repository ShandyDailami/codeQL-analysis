import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_06171_CredentialValidator_A03 implements CredentialValidator {

    // This is a simple rule that only permits passwords with a specific length
    private static final int PASSWORD_LENGTH = 8;

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) {
        String password = credential.getCredential();

        if (password.length() < PASSWORD_LENGTH) {
            return CredentialValidationResult.failed();
        }

        return CredentialValidationResult.success();
    }
}