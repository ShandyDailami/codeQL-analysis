import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_27618_CredentialValidator_A03 {

    // Using a HashMap to store username and password
    private Map<String, String> userCredentials;

    // Constructor
    public java_27618_CredentialValidator_A03() {
        this.userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // Method for authenticating users
    public boolean authenticate(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return userCredentials.get(username).equals(password);
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.authenticate("user1", "password1")); // True
        System.out.println(validator.authenticate("user3", "password1")); // False
        System.out.println(validator.authenticate("user1", "wrongpassword")); // False
    }
}