import java.util.HashMap;

public class java_19620_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_19620_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Trying to start a new session...");
            return;
        }
        sessionMap.put(sessionId, userId);
        System.out.println("Started new session: " + sessionId + " for user: " + userId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists for the provided session id.");
            return;
        }
        sessionMap.remove(sessionId);
        System.out.println("Ended session: " + sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists for the provided session id.");
            return null;
        }
        return sessionMap.get(sessionId);
    }
}