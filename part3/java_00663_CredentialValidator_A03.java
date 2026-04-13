import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_00663_CredentialValidator_A03 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_00663_CredentialValidator_A03() {
        credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public PasswordAuthentication validate(PasswordAuthentication authentication) throws LoginException {
        String name = authentication.getCaller();
        String password = new String(Base64.getDecoder().decode(authentication.getCredentials()));

        if (credentials.containsKey(name) && credentials.get(name).equals(password)) {
            return authentication;
        } else {
            throw new LoginException("Authentication failed");
        }
    }
}