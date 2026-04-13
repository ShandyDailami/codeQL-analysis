import java.util.ArrayList;
import java.util.List;

public class java_31225_SessionManager_A01 {
    // A list to simulate a database
    private List<String> sessions = new ArrayList<>();

    // Simulate a database
    public void saveSession(String sessionId) {
        sessions.add(sessionId);
    }

    public String getSession(String sessionId) {
        // Simulate a database lookup
        if (sessionId.equals("123")) {
            return "Session Found";
        } else {
            return "Session Not Found";
        }
    }

    // Simulate a method to get all sessions
    public List<String> getAllSessions() {
        return sessions;
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void updateSession(String oldSessionId, String newSessionId) {
        int index = sessions.indexOf(oldSessionId);
        if (index != -1) {
            sessions.set(index, newSessionId);
        }
    }
}