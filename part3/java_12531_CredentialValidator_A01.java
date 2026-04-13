import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;
import javax.security.auth.Subject;
import javax.security.auth.message.AuthStatus;

public class java_12531_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(Subject subject, Object credentials) throws LoginException {
        String password = (String) credentials;
        if (password == null) {
            throw new LoginException(AuthStatus.REQUIRED_FIELDS_MISSING);
        }

        if (password.length() < 8) {
            throw new LoginException(AuthStatus.CALLING_STYLE_POLICY_VIOLATED);
        }

        if (!(password.matches(".*[0-9].*"))) {
            throw new LoginException(AuthStatus.CALLING_STYLE_POLICY_VIOLATED);
        }

        if (!(password.matches(".*[a-z].*"))) {
            throw new LoginException(AuthStatus.CALLING_STYLE_POLICY_VIOLATED);
        }

        if (!(password.matches(".*[A-Z].*"))) {
            throw new LoginException(AuthStatus.CALLING_STYLE_POLICY_VIOLATED);
        }

        return new CredentialValidatorResult.Success();
    }
}