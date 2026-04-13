import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.UsernameNotFoundException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.security.AuthenticationException;
import java.util.HashSet;
import java.util.Set;

public class java_00548_CredentialValidator_A01 implements CredentialValidator {

    private static final Set<Character> SPECIAL_CHARACTERS = new HashSet<>();

    static {
        SPECIAL_CHARACTERS.add('$');
        SPECIAL_CHARACTERS.add('@');
        SPECIAL_CHARACTERS.add('#');
        SPECIAL_CHARACTERS.add('%');
        SPECIAL_CHARACTERS.add('&');
    }

    @Override
    public boolean validate(Credential credential) throws AuthenticationException {
        String password = credential.getPassword();
        return password.length() >= 8 && containsLowerCase(password) && containsUpperCase(password) && containsSpecialCharacter(password);
    }

    private boolean containsLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(c)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> getAcceptedPasswordVariant() {
        return null;
    }

    @Override
    public boolean getAcceptedPasswordVariant(String password) throws IllegalArgumentException {
        return false;
    }

    @Override
    public void initialize(URL name, Properties properties) throws SecurityException {
        // no-op
    }

    @Override
    public boolean validate(ServerCallServer call, CallbackHandler handler, Callback[] cbs) throws IOException, AuthenticationException, AccessControlException {
        // no-op
        return false;
    }

    @Override
    public boolean validate(ServerCallServer call, CallbackHandler handler, Callback[] cbs, AccessControlContext context) throws IOException, AuthenticationException, AccessControlException {
        // no-op
        return false;
    }

    @Override
    public boolean getAcceptedPasswordVariant(String password, CallbackHandler handler, Callback[] callbacks) throws AuthenticationException, AccessControlException {
        // no-op
        return false;
    }

    @Override
    public boolean getAcceptedPasswordVariant(String password, CallbackHandler handler, Callback[] callbacks, AccessControlContext context) throws AuthenticationException, AccessControlException {
        // no-op
        return false;
    }
}