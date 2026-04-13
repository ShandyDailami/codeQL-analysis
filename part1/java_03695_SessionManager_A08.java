import java.util.*;

public class java_03695_SessionManager_A08 {
    private static Map<String, Session> sessionMap;

    static class Session {
        private String id;
        private String userId;
        private Date createTime;
        private Date updateTime;

        Session(String id, String userId) {
            this.id = id;
            this.userId = userId;
            this.createTime = new Date();
            this.updateTime = new Date();
        }

        void update() {
            this.updateTime = new Date();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Session session = (Session) obj;
            return Objects.equals(id, session.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public java_03695_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, userId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public void updateSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.update();
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}