import java.util.HashMap;

public class java_22236_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_22236_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public void stopSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a dummy session id generation for the purpose of this example
        // In a real-world application, you would need to generate a unique session id
        // This could be done by generating a random string or using a cryptographic hash function
        return "session_id";
    }

    // A method to check if a session is valid
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // A method to get the username associated with a session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }
}