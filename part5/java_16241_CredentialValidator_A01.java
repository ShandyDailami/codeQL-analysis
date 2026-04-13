import java.util.Base64;
import java.util.Optional;

public class java_16241_CredentialValidator_A01 {

    public static class Credential {
        private String username;
        private String password;

        public java_16241_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public Optional<Credential> validate(String username, String password) {
        if (username != null && username.equals(VALID_USERNAME) && 
            password != null && password.equals(VALID_PASSWORD)) {
            return Optional.of(new Credential(username, password));
        } else {
            return Optional.empty();
        }
    }
}