import java.util.HashMap;
import java.util.Map;

public class java_04939_CredentialValidator_A07 {
    private Map<String, String> userMap;

    public java_04939_CredentialValidator_A07() {
        this.userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            System.out.println("Successfully authenticated as user: " + username);
            return true;
        } else {
            System.out.println("Authentication failed for user: " + username);
            return false;
        }
    }
}