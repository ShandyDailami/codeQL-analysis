import java.util.HashMap;
import java.util.Map;

public class java_30646_SessionManager_A08 {

    // A simple hashmap for holding sessions.
    // This is not the best way for real-world applications, but it's a simple example.
    private Map<String, Session> sessions = new HashMap<>();

    // A Session object contains user information and session data.
    public class Session {
        private String user;
        private String data;

        public java_30646_SessionManager_A08(String user, String data) {
            this.user = user;
            this.data = data;
        }

        public String getUser() {
            return user;
        }

        public String getData() {
            return data;
        }
    }

    // Add a session.
    public void addSession(String user, String data) {
        sessions.put(user, new Session(user, data));
    }

    // Get a session.
    public Session getSession(String user) {
        return sessions.get(user);
    }

    // Remove a session.
    public void removeSession(String user) {
        sessions.remove(user);
    }
}