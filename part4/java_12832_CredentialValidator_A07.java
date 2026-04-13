import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Arrays;

public class java_12832_CredentialValidator_A07 {
    private static final String USER_ID_HEADER = "X-User-ID";
    private static final String AUTHENTICATION_HEADER = "Authorization";

    public boolean validateCredentials(String userId, String base64EncodedCredentials, String expectedUserId, String expectedPassword) {
        String decodedCredentials = new String(Base64.getDecoder().decode(base64EncodedCredentials));
        String[] credentials = decodedCredentials.split(":");

        if (credentials.length != 2) {
            throw new InvalidParameterException("Invalid credentials format. Expected format is username:password");
        }

        if (!credentials[0].equals(expectedUserId) || !credentials[1].equals(expectedPassword)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        return true;
    }
}