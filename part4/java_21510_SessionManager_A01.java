import java.util.HashMap;

public class java_21510_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_21510_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID already exists.");
            return null;
        } else {
            sessionMap.put(sessionId, sessionData);
            System.out.println("Session created with ID: " + sessionId);
            return sessionId;
        }
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID found: " + sessionId);
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session ID not found.");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session with ID: " + sessionId + " deleted.");
        } else {
            System.out.println("Session ID not found.");
        }
    }
}