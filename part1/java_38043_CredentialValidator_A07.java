import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Base64;

public class java_38043_CredentialValidator_A07 implements CallbackHandler {

    private String userName;
    private String password;

    public java_38043_CredentialValidator_A07(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // No actual authentication is required in a legacy style.
        // Instead, we will return the username and password as is.
        for (Callback callback : callbacks) {
            callback.setCallbackType("UserPassword");
            callback.setString(Callback.USERNAME, userName);
            callback.setString(Callback.PASSWORD, password);
        }
    }
}