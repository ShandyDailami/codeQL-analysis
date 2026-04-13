import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.login.CredentialException;

public class java_20040_CredentialValidator_A08 implements CredentialValidator {

    private static final String WEAK_PASSWORD = "Weak password";
    private static final String MEDIUM_PASSWORD = "Medium password";
    private static final String STRONG_PASSWORD = "Strong password";

    private String password;

    public CredentialValidatorResult validate(javax.security.auth.Credential credential) {
        password = credential.getCredential();

        if (password == null) {
            return CredentialValidatorResult.notAuthorized("Null password");
        }

        if (password.length() < 8) {
            return CredentialValidatorResult.outAuthorized("Password too short");
        }

        int passwordStrength = 0;

        if (password.matches(".*[0-9].*")) {
            passwordStrength++;
        }

        if (password.matches(".*[a-z].*")) {
            passwordStrength++;
        }

        if (password.matches(".*[A-Z].*")) {
            passwordStrength++;
        }

        if (password.matches(".*[@#$%^&*()+=].*")) {
            passwordStrength++;
        }

        switch (passwordStrength) {
            case 0:
                return CredentialValidatorResult.outAuthorized(WEAK_PASSWORD);
            case 1:
                return CredentialValidatorResult.outAuthorized(MEDIUM_PASSWORD);
            case 2:
                return CredentialValidatorResult.outAuthorized(STRONG_PASSWORD);
            default:
                return CredentialValidatorResult.authorized(STRONG_PASSWORD);
        }
    }
}