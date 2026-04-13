import java.util.Base64;
import java.util.Optional;

public class java_26199_CredentialValidator_A08 {

    // The CredentialValidator interface
    public interface CredentialValidator {
        Optional<String> validate(String userName, String password);
    }

    // Our custom CredentialValidator
    public static class CustomCredentialValidator implements CredentialValidator {

        private final String expectedUserName;
        private final String expectedPassword;

        public java_26199_CredentialValidator_A08(String expectedUserName, String expectedPassword) {
            this.expectedUserName = expectedUserName;
            this.expectedPassword = expectedPassword;
        }

        @Override
        public Optional<String> validate(String userName, String password) {
            if (!userName.equals(expectedUserName) || !password.equals(expectedPassword)) {
                return Optional.of("Invalid Credentials");
            }

            return Optional.empty();
        }
    }

    // Usage of our custom CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CustomCredentialValidator("user", "password");

        Optional<String> result = validator.validate("user", "password");

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Access granted");
        }

        result = validator.validate("wrongUser", "wrongPassword");

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Access granted");
        }
    }
}