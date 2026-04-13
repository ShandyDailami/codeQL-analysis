import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Arrays;

public class java_10537_CredentialValidator_A03 implements LoginModule {
    private String password;

    public java_10537_CredentialValidator_A03(String password) {
        this.password = password;
    }

    @Override
    public boolean requestCredentials(Subject subject, String authenticationId, CallbackHandler callbackHandler, String[] acceptablePasswordTypes, String[] acceptableMessageTypes) throws IOException, LoginException, AccessControlException, UnsupportedCallbackException {
        return false;
    }

    @Override
    public boolean validate(String usernameToValidate, String passwordToValidate) throws LoginException, AccessControlException {
        return this.password.equals(passwordToValidate);
    }
}

public class CredentialValidator implements javax.security.auth.login.LoginModule {
    private String password;

    public java_10537_CredentialValidator_A03(String password) {
        this.password = password;
    }

    @Override
    public boolean requestCredentials(Subject subject, String authenticationId, CallbackHandler callbackHandler, String[] acceptablePasswordTypes, String[] acceptableMessageTypes) throws IOException, LoginException, AccessControlException, UnsupportedCallbackException {
        return false;
    }

    @Override
    public boolean validate(String usernameToValidate, String passwordToValidate) throws LoginException, AccessControlException {
        return this.password.equals(passwordToValidate);
    }
}