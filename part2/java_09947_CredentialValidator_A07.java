import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_09947_CredentialValidator_A07 implements CredentialValidationResult, CallbackHandler {
    private String username;
    private char[] password;

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) {
        // Check if there's a callback
        if (callbacks == null) {
            return this;
        }

        // Get the password from the callback
        try {
            for (Callback callback : callbacks) {
                callback.handle(new java.security.AuthenticationToken());
                this.password = ((java.security.AuthenticationToken) callback).getPassword();
                this.username = ((java.security.AuthenticationToken) callback).getIdentifier();
            }
        } catch (UnsupportedCallbackException e) {
            e.printStackTrace();
        }

        // Validate the password
        if (validatePassword()) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }

    private boolean validatePassword() {
        // Check for at least 8 characters, one digit, one uppercase letter, and one special character
        Set<Character> validChars = new HashSet<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        int digitCount = 0;
        int uppercaseCount = 0;
        int specialCharCount = 0;

        for (char c : this.password) {
            if (validChars.contains(c)) {
                continue;
            } else {
                return false;
            }
        }

        for (char c : this.password) {
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else {
                specialCharCount++;
            }
        }

        if (this.password.length >= 8 && digitCount > 0 && uppercaseCount > 0 && specialCharCount > 0) {
            return true;
        } else {
            return false;
        }
    }
}