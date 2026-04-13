import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_25808_CredentialValidator_A03 {

    private static final String SECRET_KEY = "superdupersecretkey";
    private static final int MAX_KEY_LENGTH = 20;

    public static void main(String[] args) {
        validateCredentials("admin:admin");
    }

    public static void validateCredentials(String credentials) {
        Decoder decoder = Base64.getDecoder();
        String decodedCredentials = new String(decoder.decode(credentials));
        String[] decodedCredentialPairs = decodedCredentials.split(":");

        if (decodedCredentialPairs.length != 2 || decodedCredentialPairs[0].length() > MAX_KEY_LENGTH || decodedCredentialPairs[1].length() > MAX_KEY_LENGTH) {
            System.out.println("Invalid Credentials");
            return;
        }

        if (!decodedCredentials.equals(encryptCredentials(decodedCredentialPairs[0], decodedCredentialPairs[1]))) {
            System.out.println("Invalid Credentials");
            return;
        }

        System.out.println("Valid Credentials");
    }

    private static String encryptCredentials(String username, String password) {
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }
}