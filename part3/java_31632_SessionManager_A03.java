import java.util.HashMap;
import java.util.Map;

public class java_31632_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_31632_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, sessionData);
            System.out.println("Session created with ID: " + sessionId);
        }
    }

    public void retrieveSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session data for ID: " + sessionId + " is: " + sessionMap.get(sessionId));
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
            System.out.println("Session updated with ID: " + sessionId + " to data: " + newSessionData);
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted with ID: " + sessionId);
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }
}