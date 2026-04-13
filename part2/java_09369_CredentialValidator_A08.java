import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import java.util.regex.Pattern;

public class java_09369_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredential credential) {
        String password = credential.getPassword();
        if (password == null) {
            return CredentialValidationResult.failed();
        }
        if (password.length() < 8) {
            return CredentialValidationResult.failed();
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidationResult.failed();
        }
        if (!SPECIAL_CHAR_PATTERN.matcher(password).matches()) {
            return CredentialValidationResult.failed();
        }
        return CredentialValidationResult.success();
    }
}