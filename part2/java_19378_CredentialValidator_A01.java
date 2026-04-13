import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_19378_CredentialValidator_A01 {

    // This is a simple hashmap that stores user names and their encoded passwords.
    // In a real-world application, you would typically query this from a database.
    private Map<String, String> userMap;

    public java_19378_CredentialValidator_A01() {
        userMap = new HashMap<>();

        // Initialize userMap with some sample users and passwords.
        userMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        // This method attempts to decode the password for a given user.
        // If the decoded password matches the given password, the method returns true.
        // Otherwise, it returns false.

        // First, try to decode the password.
        byte[] decodedPassword = Base64.getDecoder().decode(userMap.get(user));

        // Then compare the decoded password with the given password.
        return password.equals(new String(decodedPassword));
    }
}