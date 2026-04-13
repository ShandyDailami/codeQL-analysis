import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GuardedBy;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

public class java_30733_CredentialValidator_A03 implements CallbackHandler {
    private static final String USER_ID = "user";
    private static final String PASSWORD = "password";

    @GuardedBy("this")
    private Map<String, String> credentials;

    public java_30733_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String user, String password) {
        credentials.put(user, password);
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;
                String user = callbackObj.getID();
                String password = credentials.get(user);

                if (password == null || !password.equals(callbackObj.getPassword())) {
                    throw new InvalidParameterException("Invalid username or password");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential(USER_ID, PASSWORD);

        UsernamePasswordCallback callback = new UsernamePasswordCallback("", false);

        validator.getClass().getDeclaredField("credentials").setAccessible(true);
        validator.credentials = new HashMap<>();
        validator.credentials.put(USER_ID, PASSWORD);
        validator.handle(new Callback[]{callback});
    }
}