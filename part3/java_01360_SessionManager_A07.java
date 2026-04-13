import java.util.ArrayList;
import java.util.List;

public class java_01360_SessionManager_A07 {
    private List<String> sessions = new ArrayList<>();

    public String createSession() {
        String sessionId = String.valueOf(sessions.size() + 1);
        sessions.add(sessionId);
        return sessionId;
    }

    public void validateSession(String sessionId) throws AuthFailureException {
        if (!sessions.contains(sessionId)) {
            throw new AuthFailureException("Invalid session");
        }
    }

    public void clearSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

class AuthFailureException extends Exception {
    public java_01360_SessionManager_A07(String message) {
        super(message);
    }
}