import java.util.HashMap;
import java.util.Map;

public class java_31666_CredentialValidator_A08 {

    public static void main(String[] args) {

        // Create a HashMap object to store the credentials
        Map<String, String> credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");

        // Validate the user's credentials
        String inputUsername = "user1";
        String inputPassword = "password1";
        if (validateCredentials(credentials, inputUsername, inputPassword)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    public static boolean validateCredentials(Map<String, String> credentials, String username, String password) {
        // If the entered username exists in the map, return true. Otherwise, return false.
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}