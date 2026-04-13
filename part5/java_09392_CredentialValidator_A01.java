import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;

public class java_09392_CredentialValidator_A01 {

    // hardcoded credentials
    private static final Map<String, String> hardcodedCredentials = new HashMap<>();

    static {
        hardcodedCredentials.put("alice", "password");
        hardcodedCredentials.put("bob", "secret");
    }

    public java_09392_CredentialValidator_A01() {
        // empty constructor for dependency injection
    }

    public CredentialValidationResult validate(UsernamePasswordCredential arg0) throws CredentialException, LoginException {
        String username = arg0.getIdentifier();
        String password = new String(arg0.getCredential(), "UTF-8");

        if (!hardcodedCredentials.containsKey(username) || !hardcodedCredentials.get(username).equals(password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        return new CredentialValidationResult("Success", null);
    }
}