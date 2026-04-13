import java.util.HashMap;
import java.util.Map;

public class java_24330_SessionManager_A07 {

    private Map<String, String> userMap;

    public java_24330_SessionManager_A07() {
        userMap = new HashMap<>();
        // Add some users for testing
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public String getSessionId(String username, String password) {
        // This is a very simple check for username and password. In a real-world application,
        // you would want to use a more secure method to compare passwords.
        if (userMap.get(username).equals(password)) {
            return "sessionId123"; // Simple session id, not secure
        } else {
            return null;
        }
    }

    public String getUsername(String sessionId) {
        // Assuming the sessionId is only used to get the username
        for (Map.Entry<String, String> entry : userMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                return entry.getKey();
            }
        }
        return null;
    }
}