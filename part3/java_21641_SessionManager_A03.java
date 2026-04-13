import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

public class java_21641_SessionManager_A03 implements ISessionManager {
    private Map<String, HttpSession> sessions;

    public java_21641_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    @Override
    public HttpSession createSession(String userID) {
        HttpSession session = new HttpSessionBean(userID);
        sessions.put(session.getSessionID(), session);
        return session;
    }

    @Override
    public HttpSession getSession(String sessionID) {
        return sessions.get(sessionID);
    }

    @Override
    public void destroySession(String sessionID) {
        sessions.remove(sessionID);
    }

    private class HttpSessionBean implements HttpSession {
        private String sessionID;
        private String userID;

        public java_21641_SessionManager_A03(String userID) {
            this.sessionID = UUID.randomUUID().toString();
            this.userID = userID;
        }

        @Override
        public String getSessionID() {
            return this.sessionID;
        }

        @Override
        public Object getAttribute(String name) {
            return null;
        }

        @Override
        public void setAttribute(String name, Object value) {
        }

        @Override
        public void removeAttribute(String name) {
        }

        @Override
        public List getAttributeNames() {
            return null;
        }

        public String getUserID() {
            return this.userID;
        }
    }
}