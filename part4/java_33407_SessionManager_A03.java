import java.util.HashMap;
import java.util.Map;

public class java_33407_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33407_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
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

    public void destroySession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session " + sessionId + " does not exist.");
            return;
        }
        sessionMap.remove(sessionId);
    }

    public void destroyAllSessions(String userId) {
        Map<String, String> sessionsToBeRemoved = new HashMap<>();
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                sessionsToBeRemoved.put(entry.getKey(), entry.getValue());
            }
        }
        if (sessionsToBeRemoved.isEmpty()) {
            System.out.println("Error: No sessions found for user " + userId + ".");
            return;
        }
        sessionMap.entrySet().removeIf(entry -> sessionsToBeRemoved.containsKey(entry.getKey()));
    }
}