import java.util.ArrayList;
import java.util.List;

public class java_10510_SessionManager_A08 {
    private List<String> sessions;

    public java_10510_SessionManager_A08() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(String session) {
        if (session != null) {
            this.sessions.add(session);
        } else {
            throw new IllegalArgumentException("Session cannot be null");
        }
    }

    public void removeSession(String session) {
        if (session != null && this.sessions.contains(session)) {
            this.sessions.remove(session);
        } else {
            throw new IllegalArgumentException("Session cannot be null and must be in the list");
        }
    }

    public List<String> getSessions() {
        return this.sessions;
    }
}