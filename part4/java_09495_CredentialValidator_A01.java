import java.security.InvalidParameterException;
import java.util.Base64;

public class java_09495_CredentialValidator_A01 {

    public boolean validateCredentials(String username, String password) {
        // You can implement your own logic here to validate credentials.
        // For simplicity, let's assume that the username and password are always valid.

        // Assume that the username and password are base64 encoded.
        byte[] decodedBytes = Base64.getDecoder().decode(username);
        String decodedUsername = new String(decodedBytes);
        
        decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);
        
        // You can replace the following if conditions with your own logic.
        if ("admin".equals(decodedUsername) && "password".equals(decodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Encode username and password.
        String username = Base64.getEncoder().encodeToString("admin".getBytes());
        String password = Base64.getEncoder().encodeToString("password".getBytes());

        if (validator.validateCredentials(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}