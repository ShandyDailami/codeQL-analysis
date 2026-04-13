import java.util.Base64;
import java.util.Optional;

public class java_39943_CredentialValidator_A01 {
    // Encode a string as a Base64 string
    public static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    // Decode a Base64 string back to a string
    public static String decode(String str) {
        return new String(Base64.getDecoder().decode(str));
    }

    // A method that validates a username and password
    public static Optional<String> validate(String username, String password) {
        // In a real-world scenario, you should use a secure hash algorithm to compare the passwords
        // and a secure way to store the hash and compare it in the database.
        // This is a simplified example.
        if (username.equals("admin") && decode(password).equals("password")) {
            return Optional.of("Success");
        } else {
            return Optional.empty();
        }
    }
}