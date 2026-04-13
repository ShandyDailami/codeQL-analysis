import java.util.Base64;
import java.util.Arrays;

public class java_07293_CredentialValidator_A08 {

    // This is a placeholder for a real authentication system
    public static boolean authenticate(String user, String password) {
        // You'd want to replace this with a more sophisticated system
        // For now, let's assume correct user and password
        return user.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        // Encoding the username and password
        String usernameAndPassword = "admin:password";
        String encodedCredentials = Base64.getEncoder().encodeToString(usernameAndPassword.getBytes());

        // Splitting the encoded credentials into username and password
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes, 0, decodedBytes.length);
        String username = decodedCredentials.split(":")[0];
        String password = decodedCredentials.split(":")[1];

        // Validating the credentials
        if (authenticate(username, password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}