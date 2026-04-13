import java.util.Base64;
import java.util.Optional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_19747_CredentialValidator_A03 {
    private static final String SALT = "SALT"; // This should be a random value for each user

    public static Optional<String> validate(String username, String password) {
        Optional<String> hashedPassword = hashPassword(password, username);
        if (hashedPassword.isPresent()) {
            if (hashedPassword.get().equals(hashedPasswordFor(username))) {
                return Optional.of("Logged in");
            } else {
                return Optional.of("Wrong password");
            }
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(salt.getBytes() + password.getBytes());
            return Optional.of(Base64.getEncoder().encodeToString(hash));
        } catch (NoSuchAlgorithmException e) {
            return Optional.empty();
        }
    }

    private static String hashedPasswordFor(String username) {
        // This is a placeholder for a more complex password hashing logic
        return hashPassword(username, SALT).orElse("");
    }
}