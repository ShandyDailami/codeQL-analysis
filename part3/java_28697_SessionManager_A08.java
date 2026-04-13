import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class java_28697_SessionManager_A08 {

    private Map<String, HttpSession> sessionMap;

    public java_28697_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public HttpSession createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }

        HttpSession session = new HttpSessionImpl(sessionId);
        sessionMap.put(sessionId, session);

        return session;
    }

    public HttpSession getSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }

        return session;
    }

    public void destroySession(String sessionId) {
        HttpSession session = sessionMap.remove(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }
    }

    public void invalidateSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }

        session.invalidate();
    }

    public boolean isValidSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);

        return session != null && session.isValid();
    }
}