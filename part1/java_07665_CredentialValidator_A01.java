import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_07665_CredentialValidator_A01 {
    public static void main(String[] args) {
        String correctUsername = "admin";
        String correctPassword = "password";

        String enteredUsername = "admin";
        String enteredPassword = "password";

        Decoder decoder = Base64.getDecoder();

        byte[] decodedBytes = decoder.decode("YOUR_BASE64_ENCODED_CREDENTIALS");
        String decodedCredentials = new String(decodedBytes, "UTF-8");

        String[] credentials = decodedCredentials.split(":");

        String decodedUsername = credentials[0];
        String decodedPassword = credentials[1];

        boolean valid = (decodedUsername.equals(correctUsername)) && (decodedPassword.equals(correctPassword));

        if (valid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}