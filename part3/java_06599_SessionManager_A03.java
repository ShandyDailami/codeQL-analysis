import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class java_06599_SessionManager_A03 {
    private Map<String, HttpSession> sessionMap;

    public java_06599_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public Collection<HttpSession> getAllSessions() {
        return sessionMap.values();
    }

    public int getActiveSessionsCount() {
        return sessionMap.size();
    }
}