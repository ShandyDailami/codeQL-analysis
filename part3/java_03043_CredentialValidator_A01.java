import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.username.UsernamePasswordCallbackHandler;
import javax.security.auth.validator.Validator;
import javax.security.auth.validator.ValidatorResult;

public class java_03043_CredentialValidator_A01 implements Validator {

    // Hardcoded database of valid usernames and passwords
    private static final String[][] validUsers = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"},
        {"user5", "password5"}
    };

    @Override
    public ValidatorResult validate(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException {

        // Use a CallbackHandler to get the credentials
        Callback callback = callbackHandler.getCallback();

        // Get the username and password from the callback
        String username = ((UsernamePasswordCallbackHandler)callback).getUsername();
        char[] password = ((UsernamePasswordCallbackHandler)callback).getPassword();

        // Validate the username and password
        for (String[] user : validUsers) {
            if (user[0].equals(username) && user[1].equals(new String(password))) {
                return new CredentialValidationResult(username, "Validated", null, null);
            }
        }

        return new CredentialValidationResult("Invalid", null, null, null);
    }
}