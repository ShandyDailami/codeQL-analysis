import java.util.Base64;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_09243_CredentialValidator_A01 implements CallbackHandler {

    private String expectedUsername;
    private String expectedPassword;

    public java_09243_CredentialValidator_A01(String username, String password) {
        this.expectedUsername = username;
        this.expectedPassword = password;
    }

    @Override
    public Credential getCredential(Subject subject, String assertion) throws LoginException {
        return new Credential() {

            @Override
            public String getAuthID() {
                return "User";
            }

            @Override
            public Object getCredentials() {
                return expectedPassword;
            }

            @Override
            public void initialize(Subject subject, Object callbackHandler,
                    Map<String, Object> context) throws IllegalArgumentException,
                    UnsupportedCallbackException {
            }
        };
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        // Do nothing
    }
}