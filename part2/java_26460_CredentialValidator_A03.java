import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_26460_CredentialValidator_A03 implements CallbackHandler {

    private final Set<String> allowedUsers = new HashSet<>(Arrays.asList("user1", "user2", "user3"));

    @Override
    public boolean checkPassword(String password) {
        return allowedUsers.contains(password);
    }

    @Override
    public boolean getCredentials(String callingMethod, String requestFeatures, Subject callingSubject, Callback[] callbacks)
            throws IOException, LoginException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];
        boolean valid = checkPassword(callback.getPassword());
        callback.setPassword("");
        return valid;
    }

    @Override
    public boolean validate(Subject subject, String callingMethod, Object callbackReference, Set<? extends Callback> callbacks) {
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        CallbackHandler handler = new CustomCredentialValidator();

        // Uncomment this line to test the custom credential validator.
        // CustomCredentialValidator ccv = (CustomCredentialValidator) handler;
        // System.out.println(ccv.checkPassword("user1"));
    }
}