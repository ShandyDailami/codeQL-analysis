import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_00288_CredentialValidator_A07 {

    // A map to hold users and their passwords
    private static Map<String, String> userMap = new HashMap<>();

    // Initialize userMap with some dummy users
    static {
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public static boolean validateCredentials(String user, String password) {
        // Check if user exists in the map
        if (!userMap.containsKey(user)) {
            return false;
        }

        // Decode the password from Base64
        String decodedPassword = new String(Base64.getDecoder().decode(userMap.get(user)));

        // Compare the decoded password with the provided password
        return decodedPassword.equals(password);
    }

    public static void main(String[] args) {
        // Validate credentials
        boolean isValid = validateCredentials("user1", "password1");
        System.out.println("Is Valid Credentials: " + isValid);
    }
}