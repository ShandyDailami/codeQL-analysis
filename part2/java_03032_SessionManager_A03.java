import java.util.HashMap;
import java.util.Map;

public class java_03032_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_03032_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class InjectionExample {
    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        // Create a session and start it
        String sessionId = "A123";
        String userId = "User1";
        sessionManager.startSession(sessionId, userId);

        // Attempt to get the userId through an injection
        // This should not be possible because the sessionId is not a valid session ID
        String injectionUserId = "User2";
        if (sessionManager.isValidSession(sessionId)) {
            System.out.println("Attempting to inject userId: " + injectionUserId);
            // This should not be possible because the session ID is not a valid session ID
        }

        // End the session
        sessionManager.endSession(sessionId);
    }
}