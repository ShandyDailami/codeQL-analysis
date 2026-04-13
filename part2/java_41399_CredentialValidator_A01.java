import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;

public class java_41399_CredentialValidator_A01 {

    public CredentialValidationResult validate(Subject subject, Credential credential) {
        String username = credential.getCredentialIdentifier();
        String password = credential.getCredential();

        // Simulate a login process
        boolean isValid = authenticate(username, password);

        if (isValid) {
            return new CredentialValidationResult("Validated", "CREDENTIALS");
        } else {
            return new CredentialValidationResult("Invalid Credentials", null);
        }
    }

    private boolean authenticate(String username, String password) {
        // In a real-world application, you would typically fetch these from a database
        Map<String, String> users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");

        return users.containsKey(username) && users.get(username).equals(password);
    }
}