import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

public class java_40574_SessionManager_A03 {
    private Map<String, HttpSession> sessionMap;

    public java_40574_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setSessionId(sessionId);
        sessionMap.put(sessionId, session);
    }

    public void deleteSession(String sessionId, HttpServletRequest request) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
        sessionMap.remove(sessionId);
    }

    public boolean containsSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}