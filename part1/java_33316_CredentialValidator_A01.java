import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33316_CredentialValidator_A01 {

    // Use a HashMap for storing users and their encoded passwords.
    private Map<String, String> users = new HashMap<>();

    public java_33316_CredentialValidator_A01() {
        users.put("admin", Base64.getEncoder().encodeToString("admin123".getBytes()));
        users.put("user1", Base64.getEncoder().encodeToString("user123".getBytes()));
    }

    // Method to authenticate a user.
    public boolean authenticate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isAuthenticated = validator.authenticate("admin", "admin123");
        System.out.println("Is authenticated? " + isAuthenticated); // Should print: Is authenticated? true

        isAuthenticated = validator.authenticate("user1", "wrongpassword");
        System.out.println("Is authenticated? " + isAuthenticated); // Should print: Is authenticated? false
    }
}