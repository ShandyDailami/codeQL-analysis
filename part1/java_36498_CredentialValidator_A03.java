import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_36498_CredentialValidator_A03 implements CallbackHandler {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{3,20}$");

    @Override
    public CredentialValidationResult validate(Callback callback) throws UnsupportedCallbackException {
        String username = (String) callback.getUsername();
        String password = (String) callback.getPassword();

        if (validateUsername(username) && validatePassword(password)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.NOT_VALID;
        }
    }

    private boolean validateUsername(String username) {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        // Assuming passwords are not checked for containing specific injection patterns
        return true;
    }
}