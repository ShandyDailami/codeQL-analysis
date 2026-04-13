import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_33668_CredentialValidator_A07 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_33668_CredentialValidator_A07() {
        // Initialize credentials
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential arg0) throws LoginException {
        // Get the user's input
        String username = arg0.getIdentifier();
        String password = new String(arg0.getCredential());

        // Validate the credentials
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            // If the credentials are valid, return the validated credential
            return arg0;
        } else {
            // If the credentials are not valid, throw a LoginException
            throw new LoginException("Invalid username or password");
        }
    }
}