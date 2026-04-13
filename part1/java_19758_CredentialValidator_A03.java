import javax.security.auth.CredentialValidator;
import javax.security.auth.Subject;
import javax.security.auth.password.PasswordState;
import java.security.AccessControlException;

public class java_19758_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public PasswordState validate(Subject subject, Object credentials) throws AccessControlException {
        String password = (String) credentials;
        if (password == null) {
            return PasswordState.NOT_PERMITTED;
        }
        if (password.length() < 8) {
            return PasswordState.PARTIAL;
        }
        if (!password.matches(".*[a-z].*")) {
            return PasswordState.PARTIAL;
        }
        if (!password.matches(".*[A-Z].*")) {
            return PasswordState.PARTIAL;
        }
        if (!password.matches(".*[0-9].*")) {
            return PasswordState.PARTIAL;
        }
        return PasswordState.IS_FUTURE;
    }
}