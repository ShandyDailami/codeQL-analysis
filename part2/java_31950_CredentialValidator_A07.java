import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Pattern;

public class java_31950_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_.]+$";

    @Override
    public String validate(String arg0) throws CredentialException, InvalidCredentialException {
        if (!isValidUsername(arg0)) {
            throw new InvalidCredentialException("Invalid username");
        }
        return null;
    }

    private boolean isValidUsername(String username) {
        return Pattern.matches(USERNAME_PATTERN, username);
    }
}