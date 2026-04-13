import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_22646_CredentialValidator_A03 {

    private static final String AUTHENTICATED_USER = "admin:admin";
    private static final String BASIC_AUTHENTICATION = "Basic ";

    public static void main(String[] args) {
        String userAndPassword = "admin:admin";
        String base64Credentials = encodeCredentials(userAndPassword);
        System.out.println("Authorization: " + base64Credentials);
    }

    private static String encodeCredentials(String userAndPassword) {
        byte[] encodedBytes = Base64.getEncoder().encode(userAndPassword.getBytes());
        return BASIC_AUTHENTICATION + new String(encodedBytes);
    }

    public boolean isUserAuthenticated(String user, String password) {
        return user.equals(userAndPassword);
    }
}