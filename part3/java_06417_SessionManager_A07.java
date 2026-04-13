import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_06417_SessionManager_A07 {
    private Map<String, HttpSession> sessionMap;

    public java_06417_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public HttpSession createSession(String sessionId) {
        HttpSession session = new HttpSessionImpl(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
            sessionMap.remove(sessionId);
        }
    }

    private class HttpSessionImpl implements HttpSession {
        private String sessionId;

        public java_06417_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public long getCreationTime() {
            return 0;
        }

        @Override
        public String getId() {
            return sessionId;
        }

        @Override
        public long getLastAccessTime() {
            return 0;
        }

        @Override
        public void setLastAccessedTime(long lastAccessedTime) {

        }

        @Override
        public int getMaxInactiveInterval() {
            return 0;
        }

        @Override
        public void setMaxInactiveInterval(int interval) {

        }

        @Override
        public void setAttribute(String name, Object value) {

        }

        @Override
        public Object getAttribute(String name) {
            return null;
        }

        @Override
        public void removeAttribute(String name) {

        }

        @Override
        public void invalidate() {
            destroySession(sessionId);
        }

        @Override
        public boolean isValid() {
            return false;
        }
    }
}