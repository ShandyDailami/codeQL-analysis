import java.security.InvalidParameterException;
import java.security.AuthenticationException;
import java.security.Credential;
import java.security.AccessControlException;

public class java_23017_CredentialValidator_A08 {

    private static final String[][] creds = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    public java_23017_CredentialValidator_A08() {
        // empty constructor
    }

    public Credential.TokenResult validate(Credential credential) throws AuthenticationException {
        String username = credential.getIdentifier();
        char[] password = credential.getPassword();

        for (String[] cred : creds) {
            if (cred[0].equals(username) && cred[1].equals(String.valueOf(password))) {
                return new Credential.TokenResult(credential.getIdentifier(), credential.getPassword(), true);
            }
        }

        throw new AccessControlException("Access to the system is not allowed.");
    }
}