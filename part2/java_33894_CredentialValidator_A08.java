import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_33894_CredentialValidator_A08 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) {
        if (credential.getPassword() == null) {
            return CredentialValidatorResult.error("Password cannot be null");
        }

        if (!credential.getPassword().matches(PASSWORD_PATTERN)) {
            return CredentialValidatorResult.error("Password should contain at least one uppercase letter, one lowercase letter, one special character and one number");
        }

        return CredentialValidatorResult.success();
    }
}