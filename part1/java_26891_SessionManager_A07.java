import java.util.ArrayList;
import java.util.List;

public class java_26891_SessionManager_A07 {

    private List<String> activeSessions;

    public java_26891_SessionManager_A07() {
        activeSessions = new ArrayList<>();
    }

    public void addSession(String sessionId) {
        activeSessions.add(sessionId);
    }

    public void removeSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public List<String> getActiveSessions() {
        return activeSessions;
    }
}