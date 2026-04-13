import java.util.HashMap;
import java.util.Map;

public class java_04574_CredentialValidator_A01 {

    // Map to store user credentials
    private Map<String, String> credentials;

    public java_04574_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    // Method to add a user
    public void addUser(String username, String password) {
        this.credentials.put(username, password);
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        // check if username and password exists in the map
        if(this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addUser("user1", "password1");
        validator.addUser("user2", "password2");

        System.out.println(validator.authenticate("user1", "password1")); // should print true
        System.out.println(validator.authenticate("user1", "wrongpassword")); // should print false
        System.out.println(validator.authenticate("user3", "password3")); // should print false
    }
}