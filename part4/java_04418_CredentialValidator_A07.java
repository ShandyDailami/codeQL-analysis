import java.security.Provider;
import java.security.Security;
import java.security.AuthenticationException;
import java.util.Iterator;

public class java_04418_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public Provider getProvider() {
        return Security.getProvider("Sun");
    }

    @Override
    public void validate(javax.security.auth.credential.Credential credential) throws AuthenticationException {
        if (credential == null) {
            throw new IllegalArgumentException("null credentials");
        }

        String username = credential.getIdentifier();
        String password = (String) credential.getCredentials();

        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            throw new AuthenticationException("Invalid credentials");
        }
    }

    @Override
    public Iterator getIterators() {
        return null;
    }
}