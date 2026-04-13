import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.validation.Validator;

public class java_06710_CredentialValidator_A03 implements Validator {

    private static final Set<String> USERNAME_PATTERNS = new HashSet<String>(Arrays.asList("^[a-zA-Z0-9]*$", "^[a-zA-Z0-9._%+-]*$", "^[a-zA-Z0-9.-]*$"));
    private static final Set<Character> PASSWORD_PATTERNS = new HashSet<Character>(Arrays.asList('$', '@', '#', '%', '^', '&'));

    public CredentialValidationResult validate(Subject subject, Credential credential) throws CredentialException {

        String username = credential.getUsername();
        String password = credential.getPassword();

        if (!usernamePatternsMatch(username)) {
            return new CredentialValidationResult("Invalid username", null);
        }

        if (!passwordPatternsMatch(password)) {
            return new CredentialValidationResult("Invalid password", null);
        }

        return new CredentialValidationResult("Valid", null);
    }

    private boolean usernamePatternsMatch(String username) {
        for (String pattern : USERNAME_PATTERNS) {
            if (username.matches(pattern)) {
                return true;
            }
        }
        return false;
    }

    private boolean passwordPatternsMatch(String password) {
        for (Character pattern : PASSWORD_PATTERNS) {
            if (password.contains(pattern.toString())) {
                return true;
            }
        }
        return false;
    }
}