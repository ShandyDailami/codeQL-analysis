import java.util.Base64;
import java.util.Optional;

public class java_17822_CredentialValidator_A01 {

    private final CredentialRepository repository;

    public java_17822_CredentialValidator_A01(CredentialRepository repository) {
        this.repository = repository;
    }

    public Optional<String> validateCredentials(String username, String password) {
        // Step 1: Verify if the user exists in the database.
        // If the user does not exist, return an Optional.empty()
        Optional<User> userOptional = repository.findByUsername(username);
        if (userOptional.isEmpty()) {
            return Optional.empty();
        }

        // Step 2: Compare the hashed password from the database with the hashed password of the provided password.
        User user = userOptional.get();
        if (!isValidPassword(user.getPassword(), password)) {
            return Optional.empty();
        }

        // If the user exists and the password is valid, return the username.
        return Optional.of(user.getUsername());
    }

    private boolean isValidPassword(String hashedPassword, String password) {
        // This method should return true if the provided password is valid.
        // For simplicity, we're just checking if the password and hashed password are the same.
        // In a real-world application, you'd likely use a hashing algorithm such as bcrypt or Argon2 to store passwords securely.
        return hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // This method should return a hashed version of the provided password.
        // For simplicity, we're just hashing the password using base64.
        // In a real-world application, you'd likely use a hashing algorithm such as bcrypt or Argon2 to store passwords securely.
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}