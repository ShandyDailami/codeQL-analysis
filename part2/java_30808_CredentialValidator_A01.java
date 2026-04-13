import javax.security.auth.Subject;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.password.PasswordState;

public class java_30808_CredentialValidator_A01 implements PasswordValidator {
    @Override
    public PasswordState validate(Subject subject, String password) {
        if (password == null) {
            return PasswordState.ERROR;
        }

        if (!(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") &&
                password.matches(".*[0-9].*") && password.matches(".*[!@#\$%\^&\*].*"))) {
            return PasswordState.ERROR;
        }

        return PasswordState.VALID;
    }
}