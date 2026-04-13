import java.util.Base64;
import java.util.UUID;

public class java_34927_CredentialValidator_A03 {

    public boolean isValidUser(String userId, String password) {
        // Step 1: Verify the userId
        // This is a security-sensitive operation related to A03_Injection
        // Let's assume a simple check for a UUID pattern
        try {
            UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            return false;
        }

        // Step 2: Decode the password
        // This is a security-sensitive operation related to A03_Injection
        // Let's assume a base64 decoding
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Step 3: Verify the password
        // This is a security-sensitive operation related to A03_Injection
        // Let's assume a simple check for a string pattern (e.g., length >= 8)
        if (decodedPassword.length < 8) {
            return false;
        }

        return true;
    }
}