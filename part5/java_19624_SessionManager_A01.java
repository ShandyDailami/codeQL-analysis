import java.util.ArrayList;
import java.util.List;

public class java_19624_SessionManager_A01 {

    private List<String> sessions;

    public java_19624_SessionManager_A01() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(String sessionId) {
        sessions.add(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public String getSession(String sessionId) {
        for (String id : sessions) {
            if (id.equals(sessionId)) {
                return id;
            }
        }
        return null;
    }

    public boolean hasSession(String sessionId) {
        return sessions.contains(sessionId);
    }
}