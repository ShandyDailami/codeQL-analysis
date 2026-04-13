import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Collections;
import java.util.Map;

public class java_02940_SessionManager_A01 {
    private Map<String, HttpSession> sessionMap;

    public java_02940_SessionManager_A01() {
        sessionMap = Collections.synchronizedMap(new java.util.HashMap<String, HttpSession>());
    }

    public String createSession(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        sessionMap.put(sessionId, request.getSession());
        return sessionId;
    }

    public HttpSession getSession(HttpServletRequest request, String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session == null) {
            session = request.getSession();
            sessionMap.put(session.getId(), session);
        }
        return session;
    }

    public boolean invalidateSession(HttpServletRequest request, String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session == null) {
            return false;
        }
        sessionMap.remove(sessionId);
        session.invalidate();
        return true;
    }

    public void destroySession(HttpServletRequest request, String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session == null) {
            return;
        }
        sessionMap.remove(sessionId);
        session.removeAttribute("session");
    }
}