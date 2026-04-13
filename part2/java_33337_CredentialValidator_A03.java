import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AuthenticationException;
import java.security.GuaranteedAccessException;
import java.util.HashMap;
import java.util.Map;

public class java_33337_CredentialValidator_A03 implements LoginModule {

    private Map<String, String> credentials;

    public java_33337_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, String> map)
            throws IOException, UnsupportedCallbackException, AuthenticationException {
        callbackHandler.handle(new Callback[]{new UsernamePasswordCallback("")});
        this.credentials.put("username", "admin");
        this.credentials.put("password", "password");
    }

    @Override
    public boolean validate(Subject subject, String username, String password) throws AuthenticationException {
        return this.credentials.get("username").equals(username)
                && this.credentials.get("password").equals(password);
    }

    @Override
    public boolean commit() throws AuthenticationException {
        return true;
    }

    @Override
    public boolean abort() throws AuthenticationException {
        return true;
    }

    @Override
    public boolean supportsStaticCallbackHandler() {
        return false;
    }

    @Override
    public boolean supportsCallbackHandler(CallbackHandler callbackHandler) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public boolean isLegacy() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Custom Authentication Service";
    }
}

class UsernamePasswordCallback implements Callback {
    private String username;

    public java_33337_CredentialValidator_A03(String username) {
        this.username = username;
    }

    @Override
    public String getCallerIdentity() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public boolean prompt(String s) {
        return true;
    }

    @Override
    public void setPassword(String s) {
        // No-op
    }

    @Override
    public boolean isIdAvailable() throws AuthenticationException {
        return true;
    }

    @Override
    public boolean isPasswordAvailable() {
        return true;
    }
}