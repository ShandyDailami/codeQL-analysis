import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_35970_CredentialValidator_A01 implements AuthenticationService, LoginModule {

    private Map<String, String> credentials;
    private String user;
    private String password;

    public java_35970_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    @Override
    public Subject login() throws LoginException {
        return login(null);
    }

    @Override
    public Subject login(String argument) throws LoginException {
        if (credentials.containsKey(argument) && credentials.get(argument).equals(password)) {
            return new Subject() {
                @Override
                public boolean authenticate(Subject subject) throws LoginException {
                    return true;
                }
            };
        }
        return null;
    }

    @Override
    public boolean validate(Subject subject, Object object) throws LoginException {
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        return false;
    }

    @Override
    public void initialize(InputStream pin, Map<String, String> options) throws LoginException {
        this.password = options.get("password");
        this.user = new String(Base64.getDecoder().decode(options.get("user")));
    }

    @Override
    public boolean supportsPasswordBasedAuthentication() {
        return true;
    }

    @Override
    public boolean supportsCallbacks() {
        return true;
    }

    @Override
    public boolean supportsStoringPreAuthenticatedGrants() {
        return false;
    }

    @Override
    public String getName() {
        return "CredentialValidator";
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }
}