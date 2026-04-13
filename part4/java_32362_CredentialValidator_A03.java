import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.CredentialInvalidException;

public class java_32362_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern VALID_USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
    private static final Pattern VALID_PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$");

    @Override
    public String validate(Credential credential) throws CredentialInvalidException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        Matcher usernameMatcher = VALID_USERNAME_PATTERN.matcher(username);
        Matcher passwordMatcher = VALID_PASSWORD_PATTERN.matcher(password);

        if (!usernameMatcher.matches() || !passwordMatcher.matches()) {
            throw new CredentialInvalidException("Invalid username or password");
        }

        return null;
    }

    @Override
    public boolean validate(Credential credential, boolean requireMatch) throws LoginException {
        return requireMatch;
    }
}