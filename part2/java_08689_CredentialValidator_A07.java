import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class java_08689_CredentialValidator_A07 {

    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public Credential validate(Credential credential) {
        String username = credential.getIdentifier();
        char[] password = credential.getPassword();

        if (credentials.containsKey(username) &&
            credentials.get(username).equals(new String(password))) {
            return new Authenticator(username);
        }

        return null;
    }

    public class Authenticator implements Credential {

        private final String identifier;

        public java_08689_CredentialValidator_A07(String identifier) {
            this.identifier = identifier;
        }

        @Override
        public String getIdentifier() {
            return identifier;
        }

        @Override
        public char[] getPassword() {
            return null; // Returning null as password is not needed
        }
    }
}