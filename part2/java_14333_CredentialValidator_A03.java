import javax.security.auth.Subject;
import javax.security.auth.password.CredentialValidator;
import javax.security.auth.password.PasswordChangeAllowedException;
import javax.security.auth.password.PasswordRequiresUserActionException;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialException;

public class java_14333_CredentialValidator_A03 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public String getPasswordName() {
        return "CustomPassword";
    }

    @Override
    public String validate(Subject subject, String password) throws CredentialException {
        if (password == null) {
            throw new CredentialException("Password cannot be null");
        }

        boolean hasSpecialCharacter = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasSpecialCharacter && hasDigit) {
                return password;
            }
        }

        if (!hasSpecialCharacter || !hasDigit) {
            throw new CredentialException("Password must contain at least one digit and one special character");
        }

        return password;
    }
}