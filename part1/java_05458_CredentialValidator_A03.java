import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.GuaranteedAccessException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_05458_CredentialValidator_A03 implements CallbackHandler {

    private static final String CORRECT_PASSWORD = "correct_password";

    @Override
    public boolean validate(Subject subject, Callback[] callbacks) throws GuaranteedAccessException, LoginException {
        Set<String> acceptedUsernames = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
        Set<String> acceptedPasswords = new HashSet<>(Arrays.asList("correct_password", "12345", "password"));

        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        String username = callback.getIdentifier();
        String password = callback.getPassword();

        if (acceptedUsernames.contains(username) && acceptedPasswords.contains(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        CallbackHandler handler = new CallbackHandler() {
            @Override
            public boolean validate(Subject subject, Callback[] callbacks) throws LoginException, GuaranteedAccessException {
                return validator.validate(subject, callbacks);
            }
        };

        Callback[] callbacks = new Callback[1];
        callbacks[0] = new UsernamePasswordCallback("user1", CORRECT_PASSWORD);

        handler.validate(null, callbacks);
    }
}