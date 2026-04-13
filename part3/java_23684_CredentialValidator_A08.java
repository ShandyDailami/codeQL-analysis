import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_23684_CredentialValidator_A08 implements LoginModule {
    private String username;
    private String password;

    public java_23684_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, String> options) throws LoginException, UnsupportedCallbackException {
        // no-op
    }

    @Override
    public boolean login() throws LoginException {
        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean commit() throws LoginException {
        return login();
    }

    @Override
    public void cleanup() throws LoginException {
        // no-op
    }
}

public class CredentialValidator implements javax.security.auth.spi.CredentialValidationResult {
    private String username;
    private String password;

    public java_23684_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean success() {
        return true;
    }

    @Override
    public boolean failureReason(String reason) {
        return false;
    }

    @Override
    public boolean getInfo(String s) {
        return false;
    }

    public boolean validate(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        CustomLoginModule loginModule = new CustomLoginModule(username, password);
        Subject subject = new Subject.Builder().build();
        callbackHandler.handle(new Callback[]{loginModule}, subject);
        loginModule.initialize(subject, callbackHandler, null);
        loginModule.login();
        return true;
    }
}