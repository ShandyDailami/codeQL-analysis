import java.util.Base64;
import java.util.Optional;

public class java_30148_CredentialValidator_A03 {
    // A simple insecure credential validator. It's not recommended to use this in a real-world application.

    private static final String SALT = "salt"; // You should use a proper salt for a real-world application.

    public Optional<String> validate(String plainTextCredential) {
        String hashedCredential = hashCredential(plainTextCredential);

        // In a real-world application, you would also want to compare the hashed credential with a stored hashed credential.
        // This is a very simplified example and a real-world application would require a secure way to compare passwords.

        if (hashedCredential.equals(hashedCredential(plainTextCredential))) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid password");
        }
    }

    private String hashCredential(String credential) {
        // The real-world application would not use this method.
        // Instead, use a secure way to hash a password.
        return Base64.getEncoder().encodeToString((credential + SALT).getBytes());
    }

    private String hashedCredential(String credential) {
        // The real-world application would not use this method.
        // Instead, use a secure way to hash a password.
        return Base64.getEncoder().encodeToString((credential + SALT).getBytes());
    }
}