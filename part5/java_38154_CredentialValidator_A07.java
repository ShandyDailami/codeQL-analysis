import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_38154_CredentialValidator_A07 implements LoginModule {
    private Map<String, String> credentials = new HashMap<>();

    public java_38154_CredentialValidator_A07() {
        // Add some sample credentials
        credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    @Override
    public void initialize(Subject subject, String name, Map<String,?> additionalAuthenticationData, String callingPKCEndpoint) {
        // No initialization necessary in this case
    }

    @Override
    public boolean authenticate(String user, String password) throws LoginException {
        return credentials.containsKey(user) && credentials.get(user).equals(password);
    }

    @Override
    public boolean commit() throws LoginException {
        // No commit necessary in this case
        return true;
    }

    @Override
    public void cleanup() {
        // No cleanup necessary in this case
    }
}