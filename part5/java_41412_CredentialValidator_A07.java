import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_41412_CredentialValidator_A07 implements CredentialValidator {

    // Static list of usernames and passwords for testing purposes
    private static final Map<String, char[]> expectedUsersAndPasswords = new HashMap<>();

    static {
        expectedUsersAndPasswords.put("user1", "password1".toCharArray());
        expectedUsersAndPasswords.put("user2", "password2".toCharArray());
    }

    @Override
    public boolean validate(Subject subject, Object credentials, CallbackHandler callbackHandler) throws LoginException, AccessControlException {
        // Unwrap the CallbackHandler to obtain the Callback
        Callback callback = callbackHandler.getCallback();

        // Get the username and password
        String username = callback.getID();
        char[] password = (char[]) callback.getCredential();

        // Check if the username and password match our expected values
        if (expectedUsersAndPasswords.containsKey(username) && expectedUsersAndPasswords.get(username).equals(password)) {
            return true;
        } else {
            throw new LoginException("Invalid username or password");
        }
    }

    public static void main(String[] args) throws LoginException, AccessControlException, IOException, UnsupportedCallbackException {
        // Create a new CustomCredentialValidator
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Use the validator
        Subject subject = new Subject();
        subject.getPrincipals().add(new Principal("user1"));
        validator.validate(subject, "password1".toCharArray(), null);
    }
}