import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_02656_SessionManager_A08 {

    private Map<String, HttpSession> sessionMap;

    public java_02656_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
            sessionMap.remove(sessionId);
        }
    }

    public boolean checkIntegrity(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session == null) {
            return false;
        }
        if (session.isNew()) {
            // This is a new session, so it should be valid
            return true;
        }
        // This session is already validated, so it should be integrity failure
        return false;
    }
}