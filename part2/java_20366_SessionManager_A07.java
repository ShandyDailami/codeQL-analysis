import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_20366_SessionManager_A07 implements HttpSessionListener {

    private static final long serialVersionUID = 1L;

    public static class LegacySession implements HttpSession {

        private static final long serialVersionUID = 1L;

        private String sessionId;

        public java_20366_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getId() {
            return sessionId;
        }

        public void setId(String sessionId) {
            this.sessionId = sessionId;
        }

        public long getCreationTime() {
            return 0;
        }

        public void setMaxInactiveInterval(int interval) {
            // Do nothing
        }

        public int getMaxInactiveInterval() {
            return 0;
        }

        public HttpSessionContext getSessionContext() {
            return null;
        }

        public void setAttribute(String name, Object value) {
            // Do nothing
        }

        public Object getAttribute(String name) {
            // Do nothing
            return null;
        }

        public void removeAttribute(String name) {
            // Do nothing
        }

        public Collection<String> getAttributeNames() {
            // Do nothing
            return null;
        }

        public void invalidate() {
            // Do nothing
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LegacySession session = (LegacySession) se.getSession();
        session.setId("SESSION_" + System.currentTimeMillis());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Do nothing
    }
}