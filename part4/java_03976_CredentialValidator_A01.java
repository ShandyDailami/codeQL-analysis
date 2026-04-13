import java.util.HashMap;
import java.util.Map;

public class java_03976_CredentialValidator_A01 {

    // A map that contains the predefined credentials.
    private Map<String, String> credentials;

    // Constructor that initializes the credentials map.
    public java_03976_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method that validates the username and password.
    public boolean validate(String username, String password) {
        // Check if the username exists in the map.
        if (!credentials.containsKey(username)) {
            System.out.println("Invalid username!");
            return false;
        }

        // Check if the password matches the expected password for the username.
        if (!credentials.get(username).equals(password)) {
            System.out.println("Invalid password!");
            return false;
        }

        // If everything is valid, return true.
        System.out.println("Credentials validated successfully!");
        return true;
    }
}