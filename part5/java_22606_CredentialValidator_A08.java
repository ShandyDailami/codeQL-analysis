import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_22606_CredentialValidator_A08 implements CallbackHandler {
    private String userName;
    private String password;

    public java_22606_CredentialValidator_A08(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Credential getCredential(Subject subject, String callbackHandlerType)
            throws LoginException, UnsupportedCallbackException {
        if (callbackHandlerType.equals("USERNAME")) {
            return new UsernamePasswordCredential(userName);
        } else if (callbackHandlerType.equals("PASSWORD")) {
            return new UsernamePasswordCredential(password);
        }
        throw new UnsupportedCallbackException(callbackHandlerType + " not supported");
    }

    @Override
    public void setCallback(String callbackType, Callback callback) {
        // not used
    }
}