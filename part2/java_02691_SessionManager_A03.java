import java.util.HashMap;
import java.util.Map;

public class java_02691_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02691_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }

        // This is a simple way of generating a session id. 
        // In a real-world application, a secure and realistic way would be to generate a random UUID, 
        // store it in the session map, and return it.
        sessionMap.put(username, java.util.UUID.randomUUID().toString());
        return sessionMap.get(username);
    }

    public String getUsername(String sessionId) {
        // This is also a simple example of a secure operation. In a real-world application, 
        // you would retrieve the session map and look up the session id.
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                return entry.getKey();
            }
        }
        return null;
    }
}