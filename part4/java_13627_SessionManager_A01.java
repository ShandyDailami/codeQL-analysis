import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.HashMap;
import java.util.Map;

public class java_13627_SessionManager_A01 {
    private Map<String, HttpSession> sessionMap;

    public java_13627_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public HttpSession createSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session id can't be null or empty");
        }
        HttpSession session = new HttpSessionImpl(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public HttpSession getSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session id can't be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session id can't be null or empty");
        }
        sessionMap.remove(sessionId);
    }

    public void invalidateSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session id can't be null or empty");
        }
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
    }

    // We'll ignore the rest of the methods for simplicity
    // But in a real world scenario, the methods should be implemented properly
}

class HttpSessionImpl implements HttpSession {
    private String sessionId;

    public java_13627_SessionManager_A01(String sessionId) {
        this.sessionId = sessionId;
    }

    // Implement all methods of HttpSession here...

    // We'll ignore the rest of the methods for simplicity
    // But in a real world scenario, the methods should be implemented properly
}