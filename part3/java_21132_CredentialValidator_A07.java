import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_21132_CredentialValidator_A07 implements CallbackHandler {

    private static final String USER_CREDENTIALS = "user";
    private static final String PASSWORD_CREDENTIALS = "password";

    private final Map<String, String> credentials = new HashMap<>();

    public java_21132_CredentialValidator_A07() {
        credentials.put(USER_CREDENTIALS, "user");
        credentials.put(PASSWORD_CREDENTIALS, "password");
    }

    @Override
    public void handle(Callback[] callbacks) throws CredentialException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UserPasswordCallback) {
                UserPasswordCallback upCallback = (UserPasswordCallback) callback;
                String userName = upCallback.getIdentifier();
                char[] password = upCallback.getPassword();
                if (Arrays.equals(credentials.get(userName).toCharArray(), password)) {
                    upCallback.setRequestedPassword(password);
                    return;
                }
                throw new CredentialException("Invalid username or password");
            }
            throw new UnsupportedCallbackException(callback, "Unsupported callback");
        }
    }

    public static void main(String[] args) throws IOException, CredentialException {
        CustomCallbackHandler callbackHandler = new CustomCallbackHandler();
        MyCallbackHandler callback = new MyCallbackHandler(callbackHandler);
        MyUI ui = new MyUI();
        ui.enterCredentials(callback);
    }
}