import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_35197_CredentialValidator_A03 {

    // A map to store users and their credentials (in Base64)
    private Map<String, String> users;

    public java_35197_CredentialValidator_A03() {
        users = new HashMap<>();
        // Add some users for testing
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // Method for authenticating a user
    public boolean authenticate(String user, String password) {
        if (users.containsKey(user)) {
            // If the entered password matches the stored password in Base64
            return users.get(user).equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            // If the user does not exist in the map
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the authentication process
        System.out.println(validator.authenticate("user1", "password1")); // should return true
        System.out.println(validator.authenticate("user3", "password1")); // should return false
        System.out.println(validator.authenticate("user1", "wrong_password")); // should return false
    }
}