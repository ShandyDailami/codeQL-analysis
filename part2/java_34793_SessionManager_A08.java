import java.util.ArrayList;
import java.util.List;

public class java_34793_SessionManager_A08 {
    private static List<Session> sessions = new ArrayList<>();
    private static int sessionIdCounter = 0;

    public static class Session {
        public String id;
        public Object data;

        public java_34793_SessionManager_A08(Object data) {
            this.id = generateSessionId();
            this.data = data;
        }

        private static String generateSessionId() {
            sessionIdCounter++;
            return "A08_Session_" + sessionIdCounter;
        }
    }

    public static Session createSession(Object data) {
        Session session = new Session(data);
        sessions.add(session);
        return session;
    }

    public static Object getSessionData(String sessionId) {
        for (Session session : sessions) {
            if (session.id.equals(sessionId)) {
                return session.data;
            }
        }
        return null;
    }
}