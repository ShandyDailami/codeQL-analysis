import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import java.util.regex.Pattern;

public class java_07831_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) {
        String password = credential.getCredentialIdentifier();
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidatorResult.success();
        } else {
            return CredentialValidatorResult.failed();
        }
    }
}