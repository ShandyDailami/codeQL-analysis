import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_23138_CredentialValidator_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static final String AUTHORIZATION = "Basic " + Base64.getEncoder().encodeToString(USERNAME.getBytes());

    public static boolean isValidCredentials(String receivedCredentials) {
        Decoder decoder = Base64.getDecoder();
        String decodedCredentials;

        try {
            decodedCredentials = new String(decoder.decode(receivedCredentials), "UTF-8");
        } catch (Exception e) {
            return false;
        }

        String[] credentials = decodedCredentials.split(":");

        if (credentials.length != 2) {
            return false;
        }

        String givenUsername = credentials[0];
        String givenPassword = credentials[1];

        return isPasswordValid(givenUsername, givenPassword);
    }

    private static boolean isPasswordValid(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        String receivedCredentials = "Y2F0ZWdvcmluZ286MTIz"; // Basic Base64(admin:password)
        if (isValidCredentials(receivedCredentials)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}