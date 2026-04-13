import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordValidator;
import javax.security.auth.login.LoginException;

public class java_16062_CredentialValidator_A08 implements PasswordValidator {

    private static final String PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}";

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) {
        String password = credential.getPassword();

        if (password.matches(PATTERN)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}