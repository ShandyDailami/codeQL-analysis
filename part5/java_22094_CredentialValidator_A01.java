import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_22094_CredentialValidator_A01 implements CallbackHandler {

    private String username;
    private char[] password;

    public java_22094_CredentialValidator_A01(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Credential validate() {
        if (username.equals("admin") && password.toString().equals("password")) {
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            return null;
        }
    }

    @Override
    public Credential validate(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        return validate();
    }

    @Override
    public Credential validate(Callback callback) throws UnsupportedCallbackException {
        return validate();
    }
}