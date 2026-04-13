import java.util.*;

public class java_15887_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_15887_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // Step 1: Generate a random UUID.
        String sessionId = UUID.randomUUID().toString();

        // Step 2: Store the session ID and username in the map.
        sessionMap.put(sessionId, username);

        // Step 3: Return the session ID.
        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Step 1: Validate the session ID.
        if (sessionMap.containsKey(sessionId)) {
            // Step 2: Return the username associated with the session ID.
            return sessionMap.get(sessionId);
        } else {
            // Step 3: Handle the case where the session ID is not valid.
            // Here, we return null. In a real-world application, you'd want to throw an exception.
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        // Step 1: Validate the session ID.
        if (sessionMap.containsKey(sessionId)) {
            // Step 2: Remove the session ID and username from the map.
            sessionMap.remove(sessionId);
        }
    }

    public void deleteAllSessionsForUser(String username) {
        // Step 1: Iterate over all session IDs.
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            // Step 2: If the username matches, remove the session ID and username.
            if (entry.getValue().equals(username)) {
                sessionMap.remove(entry.getKey());
            }
        }
    }
}