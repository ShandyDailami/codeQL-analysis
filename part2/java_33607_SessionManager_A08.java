import java.util.HashMap;
import java.util.Map;

public class java_33607_SessionManager_A08 {
    private static Map<Integer, Session> sessions = new HashMap<>();
    private static int nextId = 1;

    public static class Session {
        private String user;

        public java_33607_SessionManager_A08(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }

    public Session createSession(String user) {
        Session session = new Session(user);
        sessions.put(nextId, session);
        return session;
    }

    public Session getSession(int id) {
        return sessions.get(id);
    }

    public void deleteSession(int id) {
        sessions.remove(id);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        Session session1 = sm.createSession("User1");
        Session session2 = sm.createSession("User2");

        System.out.println("Session1 user: " + session1.getUser());
        System.out.println("Session2 user: " + session2.getUser());

        session1.setUser("NewUser");

        System.out.println("Session1 user after update: " + session1.getUser());
        System.out.println("Session2 user after update: " + session2.getUser());

        sm.deleteSession(1);

        System.out.println("Session1 user after deletion: " + session1.getUser());
        System.out.println("Session2 user after deletion: " + session2.getUser());
    }
}