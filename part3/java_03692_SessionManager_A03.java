import java.util.*;

public class java_03692_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_03692_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        this.sessionMap.put(sessionId, username);
        System.out.println("Session started for user " + username + " with ID " + sessionId);
    }

    public String getUsername(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = this.sessionMap.get(sessionId);
        if (username != null) {
            this.sessionMap.remove(sessionId);
            System.out.println("Session ended for user " + username + " with ID " + sessionId);
        } else {
            System.out.println("No session found with ID " + sessionId);
        }
    }
}