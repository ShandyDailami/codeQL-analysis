import java.security.InvalidParameterException;
import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialCollection;
import java.util.HashMap;
import java.util.Map;

public class java_13699_CredentialValidator_A03 implements java.security.Authenticator {
    private Map<String, String> credentials = new HashMap<>();

    public java_13699_CredentialValidator_A03() {
        // Add some dummy credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public CredentialCollection authenticate(Principal p, Credential c) {
        String user = p.getName();
        String password = new String(c.getCredential(), "UTF-8");

        // Verify the credentials
        if (!credentials.containsKey(user) || !credentials.get(user).equals(password)) {
            throw new InvalidParameterException("Invalid credentials");
        }

        // Create a new CredentialCollection and add the authenticated credential
        CredentialCollection cc = new CredentialCollection();
        cc.add(c);

        return cc;
    }
}