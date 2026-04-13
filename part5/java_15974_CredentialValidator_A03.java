import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialNotFoundException;

public class java_15974_CredentialValidator_A03 implements Credential {

    // Store user credentials in a map.
    private Map<String, String> credentials = new HashMap<>();

    public java_15974_CredentialValidator_A03() {
        // Initialize the credentials map.
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String getCredential(String s) throws CredentialNotFoundException {
        if (credentials.containsKey(s)) {
            return credentials.get(s);
        } else {
            throw new CredentialNotFoundException("Credentials not found");
        }
    }

    @Override
    public String validate(String s) throws InvalidParameterException {
        // This method is not used in this example, but it could be used to validate the username and password.
        // If the credentials are valid, return the user name. Otherwise, throw an InvalidParameterException.
        if (credentials.containsKey(s) && credentials.get(s).equals(Base64.getEncoder().encodeToString(s.getBytes()))) {
            return s;
        } else {
            throw new InvalidParameterException("Invalid credentials");
        }
    }
}