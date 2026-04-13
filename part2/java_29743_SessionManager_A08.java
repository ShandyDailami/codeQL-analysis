import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class java_29743_SessionManager_A08 {
    private List<String> sessions;

    public java_29743_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void addSession(String sessionId) {
        sessions.add(sessionId);
    }

    public boolean removeSession(String sessionId) {
        return sessions.remove(sessionId);
    }

    public List<String> getSessions() {
        return Collections.unmodifiableList(sessions);
    }
}