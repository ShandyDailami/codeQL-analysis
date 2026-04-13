import java.util.HashMap;
import java.util.Map;

public class java_31050_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_31050_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // Ensure that sessionId is not already in use
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("A08_IntegrityFailure: Session already started with id " + sessionId);
            return;
        }

        // Start the session
        sessionMap.put(sessionId, userId);
        System.out.println("Session started with id " + sessionId + ", for user " + userId);
    }

    public void endSession(String sessionId) {
        // Ensure that sessionId is actually in use
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("A08_IntegrityFailure: Session with id " + sessionId + " not found");
            return;
        }

        // End the session
        sessionMap.remove(sessionId);
        System.out.println("Session ended with id " + sessionId);
    }

    public String getUserId(String sessionId) {
        // Ensure that sessionId is actually in use
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("A08_IntegrityFailure: Session with id " + sessionId + " not found");
            return null;
        }

        // Return the user id
        return sessionMap.get(sessionId);
    }
}