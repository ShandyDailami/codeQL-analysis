import java.util.HashSet;

public class java_03186_SessionManager_A07 {
    private HashSet<String> validSessions;

    public java_03186_SessionManager_A07() {
        validSessions = new HashSet<>();
    }

    public void startSession(String sessionId) {
        validSessions.add(sessionId);
    }

    public void endSession(String sessionId) throws AuthFailure {
        if (!validSessions.contains(sessionId)) {
            throw new AuthFailure("Invalid session ID");
        }
        validSessions.remove(sessionId);
    }

    public void accessSessionData(String sessionId, String data) throws AuthFailure {
        if (!validSessions.contains(sessionId)) {
            throw new AuthFailure("Invalid session ID");
        }
        // Access session data here
    }
}