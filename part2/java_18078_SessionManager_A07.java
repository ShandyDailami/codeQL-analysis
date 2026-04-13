import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_18078_SessionManager_A07 {
    private Map<String, HttpSession> sessionMap;

    public java_18078_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        sessionMap.put(sessionId, request.getSession());
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(HttpSession session) {
        sessionMap.remove(session.getId());
    }
}