import java.util.Base64;
import java.util.Optional;

public class java_09747_CredentialValidator_A03 {

    public static class Credentials {
        private final String username;
        private final String password;

        public java_09747_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public Optional<String> getPassword() {
            return Optional.ofNullable(password);
        }
    }

    public Optional<Credentials> validate(String username, String password) {
        // This is a mock call. In a real situation, you would call a secure service to verify the user.
        // For the purpose of this example, we'll just assume that the user is valid.
        return Optional.ofNullable(new Credentials(username, password));
    }

    public void validateCredentials(String username, String password) {
        // Validate credentials and then perform an action if they are valid.
        validate(username, password)
                .map(Credentials::getUsername)
                .ifPresent(user -> System.out.printf("User %s authenticated successfully%n", user));
    }
}