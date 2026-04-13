import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_13949_CredentialValidator_A08 implements CredentialValidator {

    private List<String> allowedUsers = new ArrayList<>();
    private List<String> allowedPasswords = new ArrayList<>();

    public java_13949_CredentialValidator_A08() {
        allowedUsers.add("user1");
        allowedUsers.add("user2");
        allowedUsers.add("user3");
        allowedPasswords.add("password1");
        allowedPasswords.add("password2");
        allowedPasswords.add("password3");
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler,
                           String userName,
                           String password)
            throws IOException,
            UnsupportedCallbackException {

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new UsernameCallback("Enter user name:");
        callbacks[1] = new PasswordCallback("Enter password:", true);

        // Authenticate the user
        callbackHandler.handle(callbacks);

        if ((userName != null) && (password != null)) {
            if ((allowedUsers.contains(userName)) && (allowedPasswords.contains(password))) {
                return true;
            }
        }

        // If we got here, it means the user was not found in our allowed users list
        // or the password was incorrect.
        return false;
    }

    private static class UsernameCallback
            extends UsernamePasswordCallback implements Callback {

        public java_13949_CredentialValidator_A08(String s) {
            super(s);
        }
    }

    private static class PasswordCallback
            extends UsernamePasswordCallback implements Callback {

        public java_13949_CredentialValidator_A08(String s, boolean bool) {
            super(s, bool);
        }
    }

}