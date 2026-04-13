import java.util.ArrayList;
import java.util.List;

public class java_27922_SessionManager_A03 {
    // Store sessions in memory
    private List<String> sessions = new ArrayList<>();

    // Method to start a new session
    public String startSession() {
        String sessionId = Integer.toString(sessions.size());
        sessions.add(sessionId);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessions.get(Integer.parseInt(sessionId));
    }
}