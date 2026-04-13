import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.password.PasswordAuthenticationToken;
import javax.security.auth.password.PasswordEncoder;

public class java_31345_CredentialValidator_A07 implements CallbackHandler {

    private Set<String> usernames = new HashSet<>(Arrays.asList("user1", "user2"));
    private PasswordEncoder encoder = new PasswordEncoder() {
        @Override
        public String getName() {
            return "Custom Encoder";
        }

        @Override
        public String encodePassword(String password) {
            return password;
        }

        @Override
        public boolean matches(CharSequence password, String encodedPassword) {
            return password.equals(encodedPassword);
        }
    };

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException, LoginException {
        // No-op, just to provide the interface of the CallbackHandler.
    }
}

public class CredentialValidator {

    public boolean authenticate(Subject subject, UsernamePasswordAuthenticationToken token) throws LoginException {
        String userName = token.getIdentifier();
        char[] password = token.getPassword();

        if (userName == null || password == null || userName.length() == 0 || password.length == 0) {
            return false;
        }

        if (usernames.contains(userName)) {
            if (encoder.matches(password, userName + "@SECRET")) {
                subject.getPrincipal().setName(userName);
                return true;
            }
        }

        return false;
    }
}