import java.util.HashMap;
import java.util.Map;

public class java_37868_SessionManager_A07 {

    // Define a map to hold the sessions
    private Map<String, Session> sessions;

    public java_37868_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Define a session class
    public class Session {
        private String user;

        public java_37868_SessionManager_A07(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }

    // Define a method to create a new session
    public String createSession(String user) {
        if (sessions.containsKey(user)) {
            System.out.println("A session for user " + user + " already exists.");
            return null;
        }
        Session newSession = new Session(user);
        String sessionId = newSession.getUser();
        sessions.put(sessionId, newSession);
        return sessionId;
    }

    // Define a method to retrieve a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Define a method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}