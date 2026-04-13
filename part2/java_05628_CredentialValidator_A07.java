import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.PasswordValidator;

public class java_05628_CredentialValidator_A07 implements PasswordValidator {

    private static final String STRENGTH_POLICY = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9])(?=.*[^\\s])";

    @Override
    public String getPasswordStrength(String password) {
        return password.matches(STRENGTH_POLICY) ? "Strong" : "Weak";
    }

    @Override
    public CredentialValidationResult validate(String credentials) throws CredentialException, LoginException {
        if (credentials == null || credentials.length() == 0) {
            throw new CredentialException("No credentials provided");
        }

        String passwordStrength = getPasswordStrength(credentials);
        if ("Strong".equals(passwordStrength)) {
            return CredentialValidationResult.success();
        } else {
            throw new PasswordChangeException("Password does not meet the strength requirements.");
        }
    }
}