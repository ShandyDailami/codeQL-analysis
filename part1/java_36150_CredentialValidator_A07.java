import java.util.Base64;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

public class java_36150_CredentialValidator_A07 implements CallbackHandler {

    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof SaslClient) {
                SaslClient saslClient = (SaslClient) callback;
                saslClient.notify(USER_NAME, USER_NAME, new byte[0], null);
                saslClient.notify(PASSWORD, PASSWORD, new byte[0], null);
            }
        }
    }

    public boolean validate(Subject subject, String callerPrincipal, byte[] password) {
        // Decode the password and compare it with the expected password
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        return decodedPassword.equals(PASSWORD);
    }
}