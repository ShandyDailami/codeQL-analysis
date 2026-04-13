import java.util.HashMap;

public class java_41656_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_41656_SessionManager_A07() {
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

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void checkForAuthFailure(String sessionId) {
        if (!isSessionActive(sessionId)) {
            throw new AuthFailureException("Session not active");
        }

        String userId = getUserId(sessionId);
        // Assume this is a system that checks authentication for each user
        if (!isUserAuthenticated(userId)) {
            throw new AuthFailureException("User not authenticated");
        }
    }

    private boolean isUserAuthenticated(String userId) {
        // This is a placeholder for an actual authentication check.
        // In a real application, this would involve talking to a database
        // or another external system to verify the user's identity.
        // For the sake of simplicity, this method just always returns true.
        return true;
    }
}