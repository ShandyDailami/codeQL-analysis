import java.util.HashMap;
import java.util.Map;

public class java_12506_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_12506_SessionManager_A07() {
        // Simulated database of users
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public String authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            // Generate a session ID
            return "session-" + username;
        } else {
            // Authentication failed
            return null;
        }
    }
}