import java.util.HashMap;
import java.util.Map;

public class java_34280_SessionManager_A01 {

    private Map<String, Session> sessions;

    public java_34280_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists. Please use a different session id.");
            return;
        }
        sessions.put(sessionId, new Session(username));
        System.out.println("Session with id " + sessionId + " has been created by " + username);
    }

    public void validateSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("No session with id " + sessionId + " exists.");
            return;
        }
        Session session = sessions.get(sessionId);
        if (!session.isValid()) {
            System.out.println("Session with id " + sessionId + " is invalid.");
            deleteSession(sessionId);
            return;
        }
        System.out.println("Session with id " + sessionId + " is valid.");
    }

    public void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("No session with id " + sessionId + " exists.");
            return;
        }
        sessions.remove(sessionId);
        System.out.println("Session with id " + sessionId + " has been deleted.");
    }

    private class Session {

        private String username;
        private boolean isValid;

        public java_34280_SessionManager_A01(String username) {
            this.username = username;
            this.isValid = true; // assuming sessions are always valid
        }

        public boolean isValid() {
            return isValid;
        }

        public void invalidate() {
            isValid = false;
        }

        public String getUsername() {
            return username;
        }
    }
}