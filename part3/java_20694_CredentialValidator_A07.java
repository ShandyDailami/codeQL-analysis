import java.util.HashMap;
import java.util.Map;

public class java_20694_CredentialValidator_A07 {

    private Map<String, String> userCredentials;

    public java_20694_CredentialValidator_A07() {
        this.userCredentials = new HashMap<>();
        // Add some default credentials
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        if (userCredentials.containsKey(user) && userCredentials.get(user).equals(password)) {
            System.out.println("Access granted to user: " + user);
            return true;
        } else {
            System.out.println("Access denied for user: " + user);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        validator.validateCredentials("user1", "password1"); // Expected output: "Access granted to user: user1"
        validator.validateCredentials("user1", "wrongpassword"); // Expected output: "Access denied for user: user1"
        validator.validateCredentials("user3", "password3"); // Expected output: "Access denied for user: user3"
    }
}