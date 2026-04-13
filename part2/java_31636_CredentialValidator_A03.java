import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.CredentialException;

public class java_31636_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])[a-zA-Z0-9!@#\$%\^&\*]{8,16}$");

    @Override
    public boolean validate(javax.security.auth.Credential credential) throws CredentialException, InvalidCredentialException {
        String username = credential.getUsername();
        String password = credential.getPassword();

        Matcher usernameMatcher = USERNAME_PATTERN.matcher(username);
        Matcher passwordMatcher = PASSWORD_PATTERN.matcher(password);

        if (!usernameMatcher.matches() || !passwordMatcher.matches()) {
            throw new InvalidCredentialException("Invalid username or password.");
        }

        return true;
    }
}