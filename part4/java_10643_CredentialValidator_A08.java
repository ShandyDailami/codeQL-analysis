import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;
import java.util.regex.Pattern;

public class java_10643_CredentialValidator_A08 implements CredentialValidator {
    private static final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$");

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) {
        String password = credential.getPassword();
        if (pattern.matcher(password).matches()) {
            return CredentialValidatorResult.success();
        } else {
            return CredentialValidatorResult.failed();
        }
    }
}