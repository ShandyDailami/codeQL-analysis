import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_27770_CredentialValidator_A03 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Add some hardcoded credentials
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        // Add more users as needed
    }

    public boolean validate(String username, String password) {
        // Check if the username exists in the map
        if (credentials.containsKey(username)) {
            // Decode the password from the map
            byte[] decodedPassword = Base64.getDecoder().decode(credentials.get(username));
            
            // Compare the decoded password to the input password
            return new String(decodedPassword).equals(password);
        }

        // If the username does not exist in the map, return false
        return false;
    }
}