import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_16785_CredentialValidator_A01 implements LoginModule {
    private Map<String, String> credentials = new HashMap<>();

    public java_16785_CredentialValidator_A01() {
        // Initialize credentials here
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String getName() {
        return "Credential Validator";
    }

    @Override
    public String getCaller() {
        return "caller";
    }

    @Override
    public String getCallerPrincipal() {
        return "callerPrincipal";
    }

    @Override
    public String getStatus() {
        return "status";
    }

    @Override
    public void validate(Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentialIdentifier());
        password = new String(Base64.getDecoder().decode(password));

        if (!credentials.containsKey(username) || !credentials.get(username).equals(password)) {
            throw new LoginException("Invalid username or password");
        }
    }
}