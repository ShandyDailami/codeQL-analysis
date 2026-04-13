import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_32438_CredentialValidator_A07 implements AuthenticationService, LoginModule {

    private Map<String, String> credentials;

    public java_32438_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public String getPassword(String userName) throws LoginException {
        return this.credentials.get(userName);
    }

    public String getCaller(String userName) throws LoginException {
        return userName;
    }

    public String getNextCaller(String userName) throws LoginException {
        return null;
    }

    public Subject getSubject(String callingPrincipal, boolean requestedPassword) throws LoginException {
        return new Subject.Builder()
            .setPrincipal(callingPrincipal)
            .build();
    }

    public boolean authenticate(String userName, String callingPrincipal, Map<String, String> options) throws LoginException {
        String password = this.getPassword(userName);
        if (password == null) {
            return false;
        }
        if (!password.equals(Base64.getDecoder().decode(options.get("credential")))) {
            return false;
        }
        return true;
    }

    public boolean commit() throws LoginException {
        return true;
    }

    public boolean abort() throws LoginException {
        return true;
    }

    public void initialize(Subject subject, Map<String, String> options) throws LoginException {
        this.credentials.put("user", Base64.getEncoder().encodeToString(options.get("password").getBytes()));
    }

    public void cleanup() {
        // Nothing to do
    }
}