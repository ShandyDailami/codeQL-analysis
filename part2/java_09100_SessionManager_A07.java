import java.util.HashMap;
import java.util.Map;

public class java_09100_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_09100_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        sessions.put(userId, userId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public boolean isSessionActive(String userId) {
        return sessions.containsKey(userId);
    }

    public void validateUser(String userId, String password) {
        if (!isSessionActive(userId)) {
            throw new AuthFailureException();
        }
        
        // For security sensitive operations related to A07_AuthFailure, you may want to validate password here
        // if required. If not, you can remove this part.
    }
}