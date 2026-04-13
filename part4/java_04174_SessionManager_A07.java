import java.util.HashMap;
import java.util.Map;

public class java_04174_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04174_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("A session with the id " + sessionId + " already exists.");
            return;
        }
        sessionMap.put(sessionId, username);
        System.out.println("Started session with id " + sessionId + " for user " + username);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session with the id " + sessionId + " exists.");
            return;
        }
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session with id " + sessionId + " for user " + username);
    }

    public String getUsername(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session with the id " + sessionId + " exists.");
            return null;
        }
        return sessionMap.get(sessionId);
    }
}