import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_25518_CredentialValidator_A03 {

    // A simple repository to hold the users
    private Map<String, String> users = new HashMap<>();

    // Initialize the users repository
    {
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    // The constructor
    public java_25518_CredentialValidator_A03() {
    }

    // Method to validate the user's credentials
    public boolean validate(String username, String password) {
        // If the user doesn't exist, return false
        if (!users.containsKey(username)) {
            return false;
        }

        // Decode the user's password from the database
        String decodedPassword = new String(Base64.getDecoder().decode(users.get(username)));

        // Split the decoded password into the username and password
        String[] userCredentials = decodedPassword.split(":");

        // If the password doesn't match, return false
        if (!userCredentials[1].equals(password)) {
            return false;
        }

        // If everything matches, return true
        return true;
    }
}