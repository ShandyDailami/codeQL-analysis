import java.util.Base64;
import java.util.Base64.Decoder;

public class java_08106_CredentialValidator_A01 {
    // Decoder for decoding the base64 encoded credentials
    private final Decoder decoder = Base64.getDecoder();

    // Method to validate credentials
    public boolean validate(String encodedCredentials) {
        String decodedCredentials;
        try {
            // Attempt to decode the base64 encoded credentials
            decodedCredentials = new String(decoder.decode(encodedCredentials), "UTF-8");
        } catch (Exception e) {
            // Failed to decode, return false
            return false;
        }

        // Assume the credentials are in the format username:password
        String[] credentials = decodedCredentials.split(":");
        if (credentials.length != 2) {
            // Invalid format, return false
            return false;
        }

        String username = credentials[0];
        String password = credentials[1];

        // In a real application, you would typically hash the password and compare the hashes
        // For simplicity, we'll just check if the password is "secure", which is unlikely in a real application
        return password.equals("secure");
    }
}