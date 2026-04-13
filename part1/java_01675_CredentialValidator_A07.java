import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_01675_CredentialValidator_A07 {

    private Map<String, String> credentials = new HashMap<>();

    public java_01675_CredentialValidator_A07() {
        // Add dummy credentials
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        // Validate password against stored encrypted credentials
        String encodedPassword = credentials.get(username);
        if (encodedPassword == null) {
            throw new CredentialNotFoundException("Username not found in credentials");
        }
        if (!encodedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
            throw new LoginException("Invalid password");
        }
        return true;
    }
}