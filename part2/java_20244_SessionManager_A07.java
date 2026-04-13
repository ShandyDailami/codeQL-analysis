import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_20244_SessionManager_A07 implements HttpSessionListener {
    private Map<String, HttpSession> sessionMap;

    public java_20244_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessionMap.put((String) session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessionMap.remove(session.getId());
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        return session != null && session.getAttribute(HttpSessionContext.SERVICE_COUNT) != null;
    }

    public void invalidateAllSessions() {
        sessionMap.clear();
    }
}