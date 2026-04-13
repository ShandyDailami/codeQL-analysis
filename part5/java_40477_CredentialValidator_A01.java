import java.util.Base64;
import java.util.Optional;

public class java_40477_CredentialValidator_A01 {

    // This is a simple validation that checks if a plaintext password matches a hashed password.
    // It's a simplified example and should not be used for real-world applications.
    public static Optional<String> validatePassword(String plaintext, String hashedPassword) {
        // Assume hashedPassword is base64 encoded
        Optional<String> hashed = Optional.of(new String(Base64.getDecoder().decode(hashedPassword)));
        return hashed.filter(p -> p.equals(plaintext));
    }

    // This is a simple validation that checks if a username matches a pre-defined list.
    // It's a simplified example and should not be used for real-world applications.
    public static Optional<String> validateUsername(String username, String[] preDefinedList) {
        Optional<String> optional = Optional.empty();
        for (String s : preDefinedList) {
            if (s.equals(username)) {
                optional = Optional.of(username);
                break;
            }
        }
        return optional;
    }
}