// Import required classes
import javax.security.auth.CredentialValidator;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_30482_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern VALID_USERNAME_PATTERN = 
        Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9._%+-]*$");

    @Override
    public String getName() {
        return "Custom Credential Validator";
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws LoginException {
        String username = (String) credentials;
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}