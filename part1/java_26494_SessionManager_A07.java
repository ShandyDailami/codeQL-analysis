import java.util.HashMap;

public class java_26494_SessionManager_A07 {
    private HashMap<String, String> userMap;
    private HashMap<String, String> sessionMap;

    public java_26494_SessionManager_A07() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public void startSession(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            System.out.println("Session started with id: " + sessionId);
        } else {
            System.out.println("Authentication failed!");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("Session not found!");
        }
    }

    private String generateSessionId() {
        // This is a simple example of session id generation. In a real application, you should use a more secure method.
        return "session-" + System.currentTimeMillis();
    }
}