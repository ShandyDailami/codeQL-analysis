import java.util.HashMap;

public class java_04430_SessionManager_A07 {

    // Use a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    public java_04430_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        // Simulate a session creation by generating a unique id for the session
        String sessionId = user + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        // Simulate retrieving user information based on the session id
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Simulate session deletion by invalidating the session
        sessionMap.remove(sessionId);
    }

    public void authenticate(String sessionId) throws AuthFailure {
        // Simulate authentication process by checking if the session id exists in the map
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure();
        }
    }
}