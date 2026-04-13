import java.util.ArrayList;
import java.util.List;

public class java_11273_SessionManager_A08 {

    private List<String> sessions;

    public java_11273_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void addSession(String session) {
        sessions.add(session);
    }

    public String getSession(String sessionId) {
        for (String s : sessions) {
            if (s.equals(sessionId)) {
                return s;
            }
        }
        return null;
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}