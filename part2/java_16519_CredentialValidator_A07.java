import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_16519_CredentialValidator_A07 {

    private static final String SECRET = "MySuperSecret"; // Secret key used for encryption

    private static final Encoder encoder = Base64.getEncoder();
    private static final Decoder decoder = Base64.getDecoder();

    private String secret;

    public java_16519_CredentialValidator_A07(String secret) {
        this.secret = secret;
    }

    public boolean validate(String credentials) {
        try {
            byte[] decodedCredentials = decoder.decode(credentials);
            String decodedString = new String(decodedCredentials, "UTF-8");
            return decodedString.equals(secret);
        } catch (Exception e) {
            return false;
        }
    }

    public String generateCredentials(String username, String password) {
        String credentials = username + ":" + password;
        return encoder.encodeToString(credentials.getBytes());
    }
}