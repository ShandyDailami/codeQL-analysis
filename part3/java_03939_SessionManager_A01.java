import java.util.HashMap;
import java.util.Map;

public class java_03939_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03939_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("A session already exists for user: " + userId);
            return;
        }

        sessionMap.put(userId, sessionId);
        System.out.println("A session started for user: " + userId);
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            System.out.println("No session found for user: " + userId);
            return;
        }

        sessionMap.remove(userId);
        System.out.println("A session ended for user: " + userId);
    }

    public void validateSession(String userId, String expectedSessionId) {
        if (!sessionMap.containsKey(userId)) {
            System.out.println("No session found for user: " + userId);
            return;
        }

        String currentSessionId = sessionMap.get(userId);
        if (!currentSessionId.equals(expectedSessionId)) {
            System.out.println("Invalid session for user: " + userId);
            return;
        }

        System.out.println("Valid session for user: " + userId);
    }
}