import java.security.InvalidParameterException;
import java.util.Base64;

public class java_35942_CredentialValidator_A08 {

    private static final String AUTH_PREFIX = "Basic ";

    public boolean validateCredential(String authHeader) {
        if (authHeader == null || !authHeader.startsWith(AUTH_PREFIX)) {
            throw new InvalidParameterException("Authorization header is missing or not in correct format");
        }

        String encodedCredential = authHeader.substring(AUTH_PREFIX.length());
        String decodedCredential = new String(Base64.getDecoder().decode(encodedCredential), "UTF-8");

        String[] credentialParts = decodedCredential.split(":");
        if (credentialParts.length != 2) {
            throw new InvalidParameterException("Authorization header is missing or not in correct format");
        }

        String username = credentialParts[0];
        String password = credentialParts[1];

        // Here you can add your own logic for comparing the password with the database.
        // For the sake of simplicity, we will just return true or false.
        return true;
    }
}