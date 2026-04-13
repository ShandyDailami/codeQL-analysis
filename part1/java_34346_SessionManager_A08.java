import java.util.HashMap;
import java.util.Map;

public class java_34346_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_34346_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id: " + sessionId + ", already exists.");
        } else {
            System.out.println("Created new session with id: " + sessionId);
            sessionMap.put(sessionId, userName);
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session with id: " + sessionId + ", does not exist.");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Deleted session with id: " + sessionId);
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Session with id: " + sessionId + ", does not exist.");
        }
    }

    public void validateSession(String sessionId, String expectedUser) {
        String user = this.getSession(sessionId);
        if (user != null && user.equals(expectedUser)) {
            System.out.println("User: " + user + " is authenticated as part of session: " + sessionId);
        } else {
            System.out.println("Session with id: " + sessionId + ", is invalid or not found.");
        }
    }
}