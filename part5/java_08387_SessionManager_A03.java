import java.util.ArrayList;
import java.util.List;

public class java_08387_SessionManager_A03 {
    private List<String> sessions;

    public java_08387_SessionManager_A03() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(String session) {
        if (session != null && !session.isEmpty()) {
            sessions.add(session);
        }
    }

    public void removeSession(String session) {
        if (session != null && !session.isEmpty()) {
            sessions.remove(session);
        }
    }

    public List<String> getSessions() {
        return sessions;
    }

    public void clearSessions() {
        sessions.clear();
    }

    public boolean isSessionValid(String session) {
        if (session != null && !session.isEmpty()) {
            return sessions.contains(session);
        }
        return false;
    }
}