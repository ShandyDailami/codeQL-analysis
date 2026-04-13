import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_18353_CredentialValidator_A08 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_18353_CredentialValidator_A08() {
        // Initialize credentials with example data. This should be replaced with actual data.
        this.credentials = new HashMap<String, String>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String validate(String argument) {
        String user = argument;
        String password = this.credentials.get(user);
        if (password == null) {
            throw new LoginException("Invalid username or password");
        }
        return password;
    }

    @Override
    public String getChallenge(String s, String s1, Map<String, String> map, Map<String, String> map1) throws LoginException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean validate(String s, Map<String, String> map) throws LoginException {
        throw new UnsupportedOperationException();
   
}
}