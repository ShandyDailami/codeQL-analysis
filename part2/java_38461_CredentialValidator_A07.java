import java.util.Arrays;
import java.util.List;

public class java_38461_CredentialValidator_A07 implements CredentialValidator {
    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
            new Credential("alice", "password123"),
            new Credential("bob", "password456"),
            new Credential("charlie", "password789"));

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        // Remove password from log for security reasons
        if(credential instanceof UsernamePasswordCredential) {
            ((UsernamePasswordCredential) credential).setPassword("[REMOVED]");
        }

        for (Credential cred : VALID_CREDENTIALS) {
            if (cred.matches(username, password)) {
                return true;
            }
        }
        return false;
    }

    private static class Credential {
        private final String username;
        private final String password;

        public java_38461_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}