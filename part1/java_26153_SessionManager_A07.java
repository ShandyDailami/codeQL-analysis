import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_26153_SessionManager_A07 implements SessionManager {

    private static Set<HttpSession> sessions = Collections.synchronizedSet(new HashSet<HttpSession>());

    @Override
    public HttpSession createSession(HttpSessionContext context) {
        HttpSession session = new MySession(this);
        sessions.add(session);
        return session;
    }

    @Override
    public void removeSession(HttpSession session, HttpSessionContext context) {
        sessions.remove(session);
    }

    @Override
    public HttpSession getSession(String sessionId) {
        for (HttpSession session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    private static class MySession extends BasicHttpSession {
        private SessionManager manager;

        public java_26153_SessionManager_A07(SessionManager manager) {
            this.manager = manager;
        }

        @Override
        public void setAttribute(String name, Object value) {
            // You can add your own logic here. For example, if the session is expired, you can
            // call manager.removeSession(this) and then call super.setAttribute(name, value).
            // For simplicity, we just call super.setAttribute(name, value).
            super.setAttribute(name, value);
        }
    }
}