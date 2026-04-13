import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32285_CredentialValidator_A01 {
    // Store username and password for simplicity
    private Map<String, String> userMap;

    public java_32285_CredentialValidator_A01() {
        userMap = new HashMap<>();
        userMap.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        userMap.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the user exists in the userMap
        if (userMap.containsKey(username)) {
            // Decode the password from Base64
            String decodedPassword = new String(Base64.getDecoder().decode(userMap.get(username)));

            // Split the decoded password into username and password
            String[] decodedUserPassword = decodedPassword.split(":");

            // Compare the given password with the decoded password
            if (decodedUserPassword[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}