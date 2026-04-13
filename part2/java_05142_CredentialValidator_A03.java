import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import java.util.regex.Pattern;

public class java_05142_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern ALLOWED_PASSWORD_PATTERN = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}");

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) {
        String password = credential.getCredentialIdentifier();
        if (ALLOWED_PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}