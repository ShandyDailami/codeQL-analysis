import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class java_06692_SessionManager_A03 {

    private Map<String, HttpSession> sessionMap;

    public java_06692_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public HttpSession getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void createSession(String sessionId) {
        HttpSession session = new HttpSessionImpl(sessionId);
        sessionMap.put(sessionId, session);
    }

    public void invalidateSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
        sessionMap.remove(sessionId);
    }

    public void destroySession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.destroy();
        }
        sessionMap.remove(sessionId);
    }

    public void setSessionAttribute(String sessionId, String attributeName, Object attributeValue) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.setAttribute(attributeName, attributeValue);
        }
    }

    public Object getSessionAttribute(String sessionId, String attributeName) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            return session.getAttribute(attributeName);
        } else {
            return null;
        }
    }

    public void removeSessionAttribute(String sessionId, String attributeName) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.removeAttribute(attributeName);
        }
    }
}