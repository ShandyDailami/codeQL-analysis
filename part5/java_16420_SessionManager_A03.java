import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class java_16420_SessionManager_A03 {

    private final Map<String, HttpSession> sessionMap = Collections.synchronizedMap(new HashMap<>());

    public HttpSession createSession(String sessionId) {
        HttpSession session = new HttpSessionImpl(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public void updateSession(String oldSessionId, String newSessionId) {
        HttpSession session = sessionMap.remove(oldSessionId);
        if (session != null) {
            session.invalidate();
            sessionMap.put(newSessionId, session);
        }
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        HttpSession session = sessionMap.remove(sessionId);
        if (session != null) {
            session.invalidate();
        }
    }

    private static class HttpSessionImpl extends SimpleHttpSession {

        private final String id;

        HttpSessionImpl(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return this.id;
        }
    }
}