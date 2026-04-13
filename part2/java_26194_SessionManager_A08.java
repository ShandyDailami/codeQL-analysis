import java.util.HashMap;

public class java_26194_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_26194_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session " + sessionId + " already exists.");
            return;
        }

        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session " + sessionId + " does not exist.");
            return null;
        }

        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session " + sessionId + " does not exist.");
            return;
        }

        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}