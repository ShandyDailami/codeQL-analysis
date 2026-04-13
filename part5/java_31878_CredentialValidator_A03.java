import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31878_CredentialValidator_A03 {

    // Hashmap to store valid users
    private static Map<String, String> validUsers = new HashMap<>();

    // Initializing the valid users.
    static {
        validUsers.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        validUsers.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        validUsers.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    // Method for validating the username and password.
    public boolean validateCredentials(String username, String password) {
        if (validUsers.containsKey(username) && validUsers.get(username).equals(password)) {
            System.out.println("Credentials are valid.");
            return true;
        } else {
            System.out.println("Credentials are not valid.");
            return false;
        }
    }
}