import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.SessionContext;
import java.io.Serializable;
import java.util.Map;

public class java_37558_SessionManager_A08 implements javax.servlet.http.SessionManager {

    private final Map<String, javax.servlet.http.Session> sessionMap;

    public java_37558_SessionManager_A08(Map<String, javax.servlet.http.Session> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public HttpSession createSession(Serializable id, HttpServletRequest request, HttpServletResponse response) {
        if (id == null) {
            id = "SESSION_" + System.currentTimeMillis();
        }
        HttpSession session = new HttpSessionImpl(sessionMap, id, request, response);
        sessionMap.put((String) id, session);
        return session;
    }

    @Override
    public void destroySession(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        sessionMap.remove(session.getId());
    }

    @Override
    public void invalidateSession(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        destroySession(session, request, response);
    }

    @Override
    public HttpSession getSession(String id) {
        return sessionMap.get(id);
    }

    @Override
    public HttpSession getSession(Serializable id, HttpServletRequest request, HttpServletResponse response) {
        return createSession(id, request, response);
    }

    @Override
    public Map<String, HttpSession> getAllSessions(HttpServletRequest request, HttpServletResponse response) {
        return sessionMap;
    }

    @Override
    public SessionContext getSessionContext(HttpServletRequest request, HttpServletResponse response) {
        return new SessionContext() {
            @Override
            public HttpSession getId() {
                return null;
            }

            @Override
            public HttpSession getInstance() {
                return null;
            }

            @Override
            public void putValue(String id, Serializable value) {
                // Do nothing
            }

            @Override
            public Serializable getValue(String id) {
                return null;
            }

            @Override
            public void validate() {
                // Do nothing
            }
        };
    }
}