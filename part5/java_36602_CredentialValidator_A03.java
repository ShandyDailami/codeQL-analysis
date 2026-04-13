import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallerCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.login.LoginException;

public class java_36602_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    private static final Pattern VALID_PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public CredentialValidationResult validate(Callback callback) throws LoginException {
        // Obtain input credentials
        final String[] creds = new String[2];
        Callback.setCredentials(callback, creds);

        // Validate credentials
        final boolean validated = validateCredentials(creds[0], creds[1]);

        // Return result of validation
        return new CredentialValidationResult(validated, "Custom Credential Validator");
    }

    private boolean validateCredentials(String username, String password) {
        // Create matcher for password
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);

        // Check if password matches pattern
        return matcher.matches();
    }
}