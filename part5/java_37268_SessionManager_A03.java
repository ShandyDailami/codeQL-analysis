import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class java_37268_SessionManager_A03 {
    private Map<String, HttpSession> sessionMap;

    public java_37268_SessionManager_A03() {
        sessionMap = Collections.synchronizedMap(new HashMap<>());
    }

    public HttpSession getSession(boolean create) {
        HttpSession session = null;
        if (create) {
            session = new HttpSession();
            sessionMap.put(((HttpSessionContext) session).getId(), session);
        } else {
            session = sessionMap.get(Thread.currentThread().getId() + "");
        }
        return session;
    }

    public void invalidateSession(HttpSession session) {
        sessionMap.remove(session.getId());
    }

    public void validateSession(HttpSession session) {
        if (session == null || session.isExpired()) {
            throw new IllegalStateException("Invalid session");
        }
    }
}