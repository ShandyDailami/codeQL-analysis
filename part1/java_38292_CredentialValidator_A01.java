import java.util.Base64;
import java.util.Base64.Decoder;

public class java_38292_CredentialValidator_A01 {

    public static void main(String[] args) {
        String userCredentials = "username:password";
        byte[] decodedCredentials = decodeCredentials(userCredentials);

        // Pass the decoded credentials to the validateCredentials method
        validateCredentials(decodedCredentials);
    }

    private static void validateCredentials(byte[] decodedCredentials) {
        String credentials = new String(decodedCredentials);
        String[] credentialsArray = credentials.split(":");

        if (credentialsArray.length != 2) {
            System.out.println("Invalid username or password");
        } else {
            String username = credentialsArray[0];
            String password = credentialsArray[1];

            if ("admin".equals(username) && "password".equals(password)) {
                System.out.println("Access granted");
            } else {
                System.out.println("Access denied");
            }
        }
    }

    private static byte[] decodeCredentials(String credentials) {
        String base64Credentials = credentials + "=="; // Adds an equal sign in the end
        Decoder decoder = Base64.getDecoder();

        return decoder.decode(base64Credentials);
    }
}