import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.ArrayList;
import java.util.List;

public class java_01558_SessionManager_A01 {
    private List<HttpSession> sessionList;

    public java_01558_SessionManager_A01() {
        sessionList = new ArrayList<>();
    }

    public void createSession(HttpSession session) {
        sessionList.add(session);
    }

    public void endSession(HttpSession session) {
        sessionList.remove(session);
    }

    public void killSession(HttpSession session) {
        endSession(session);
        session.invalidate();
    }

    public List<HttpSession> getAllSessions() {
        return sessionList;
    }

    public void invalidateAllSessions() {
        for (HttpSession session : sessionList) {
            session.invalidate();
        }
        sessionList.clear();
    }

    public HttpSession getSession(String sessionId) {
        for (HttpSession session : sessionList) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    public HttpSessionContext getSessionContext() {
        return new HttpSessionContext() {
            @Override
            public List<HttpSession> getValidSessions() {
                return getAllSessions();
            }

            @Override
            public void invalidate(HttpSession session) {
                killSession(session);
            }
        };
    }
}