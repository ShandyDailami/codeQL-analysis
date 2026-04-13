import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_02040_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential arg0) {
        if (arg0.getUsername().equals(USERNAME) && arg0.getPassword().equals(PASSWORD)) {
            return CredentialValidatorResult.success();
        } else {
            return CredentialValidatorResult.failed();
        }
    }
}