import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

public class java_23537_CredentialValidator_A08 implements CredentialValidation {

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler)
            throws AuthenticationException, java.io.IOException, UnsupportedCallbackException {
        // get the authentication request from the CallbackHandler
        Callback[] callbacks = callbackHandler.getCallbacks();
        String username = callbacks[0].getUsernameToValidate();
        char[] password = callbacks[0].getPassword();

        // Check if password is strong enough
        boolean isStrongEnough = isStrongEnough(password);

        // Return the result
        return new CredentialValidationResult(isStrongEnough, null);
    }

    private boolean isStrongEnough(char[] password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!isAlphanumeric(c)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}