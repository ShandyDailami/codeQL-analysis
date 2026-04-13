import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialException;
import java.util.regex.Pattern;

public class java_20373_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern COMMON_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\w\\d\\s:])(?=.*[^\\s]).{8,16}$");

    @Override
    public CredentialValidationResult validate(CredentialContext context) throws CredentialException {
        String name = context.getCallerPrincipal().getName();
        String password = context.getPassword();

        // Check password length
        if (password.length() < 8 || password.length() > 16) {
            return CredentialValidationResult.failure();
        }

        // Check for common password patterns
        if (!COMMON_PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidationResult.failure();
        }

        // If all checks pass, return success
        return CredentialValidationResult.success();
    }
}