import java.util.HashMap;
import java.util.Map;

public class java_39679_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_39679_CredentialValidator_A07() {
        // Using a HashMap for simplicity, in real application you would probably use a database
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        // Check if user and password exist in the map
        if (this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            // If they do, return true
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid user
        System.out.println(validator.validate("user1", "password1")); // should print true

        // Test invalid user
        System.out.println(validator.validate("user3", "password3")); // should print false

        // Test invalid password
        System.out.println(validator.validate("user1", "wrongpassword")); // should print false
    }
}