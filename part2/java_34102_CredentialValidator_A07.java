import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_34102_CredentialValidator_A07 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public CredentialValidationResult validate(PasswordAuthentication authentication) throws LoginException {
        String user = authentication.getCaller();
        String password = new String(authentication.getCredentials());

        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID_CREDENTIALS;
        }
    }
}