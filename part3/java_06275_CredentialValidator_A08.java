import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_06275_CredentialValidator_A08 {

    // A method to validate the credential.
    public Optional<String> validateCredential(String username, String password) {
        // A simple validation. However, in a real-world scenario, you would want to do more complex validation.
        // Also, consider using a secure hash function like SHA-256 for password validation.

        // Base64 decoding to convert from base64 to string.
        Optional<String> decodedPassword = decodePassword(password);

        // Validate the password.
        if (decodedPassword.isPresent()) {
            if (isValidPassword(decodedPassword.get())) {
                return Optional.of(username);
            } else {
                throw new InvalidParameterException("Invalid password");
            }
        } else {
            throw new InvalidParameterException("Invalid password");
        }
    }

    // A method to decode the password.
    private Optional<String> decodePassword(String password) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(password);
            return Optional.of(new String(decodedBytes));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // A method to check if the password is valid.
    private boolean isValidPassword(String password) {
        // You would typically use a password hashing function here to ensure the password is secure.
        // However, this is a very simplified example and does not include a real password hashing function.
        // In a real-world scenario, you would want to check if the password matches a pre-defined list or database.
        return password.equals("securePassword");
    }
}