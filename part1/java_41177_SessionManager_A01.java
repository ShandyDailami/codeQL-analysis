import java.util.HashMap;

public class java_41177_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_41177_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, userName);
        System.out.println("Started session for user: " + userName + " with session ID: " + sessionId);
    }

    public String getUserName(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            System.out.println("Invalid session ID: " + sessionId);
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String userName = sessions.get(sessionId);
            sessions.remove(sessionId);
            System.out.println("Ended session for user: " + userName + " with session ID: " + sessionId);
        } else {
            System.out.println("Invalid session ID: " + sessionId);
        }
    }

    private String generateSessionId() {
        // This is a simple example, in a real-world application you would want to use UUIDs or similar for session IDs
        return String.valueOf(System.currentTimeMillis());
    }
}