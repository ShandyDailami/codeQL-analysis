import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.FailedLoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_13535_CredentialValidator_A03 implements CallbackHandler {

    private static final Set<Character> VALID_CHARACTERS = new HashSet<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '@', '#',
            '$', '%', '^', '&', '*', '(', ')', '_', '+', '=', '-', '<', '>', '~', '`', '{', '}', '[', ']', '|', ';', ':', ',', '.', '/'));

    @Override
    public void handle(Callback[] callbacks) throws FailedLoginException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordAuthenticationToken) {
                UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) callback;
                String password = token.getPassword().toString();
                if (!isValidPassword(password)) {
                    throw new FailedLoginException("Invalid password: " + password);
                }
            } else {
                throw new UnsupportedCallbackException("Unsupported callback: " + callback.getClass().getName());
            }
        }
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (!VALID_CHARACTERS.contains(c)) {
                return false;
            }
        }
        return true;
    }
}