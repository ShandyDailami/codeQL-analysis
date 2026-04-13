import java.util.ArrayList;
import java.util.List;

public class java_11107_SessionManager_A03 {

    private List<String> sessionList;

    public java_11107_SessionManager_A03() {
        sessionList = new ArrayList<>();
    }

    public void openSession(String sessionId) {
        if (!sessionList.contains(sessionId)) {
            sessionList.add(sessionId);
        }
    }

    public void closeSession(String sessionId) {
        sessionList.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionList.contains(sessionId);
    }

    public List<String> getAllSessions() {
        return sessionList;
    }
}