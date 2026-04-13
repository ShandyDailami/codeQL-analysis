import java.util.Arrays;
import java.util.List;

public class java_10858_CredentialValidator_A07 {

    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
            new Credential("user1", "password1"),
            new Credential("user2", "password2"),
            new Credential("user3", "password3")
    );

    public boolean validate(String username, String password) {
        for (Credential credential : VALID_CREDENTIALS) {
            if (credential.matches(username, password)) {
                return true;
            }
        }
        return false;
    }

    private static class Credential {
        private final String username;
        private final String password;

        public java_10858_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}