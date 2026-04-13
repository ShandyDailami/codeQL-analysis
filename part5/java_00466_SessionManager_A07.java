import java.util.HashMap;
import java.util.Map;

public class java_00466_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_00466_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String user) {
        if (sessions.containsKey(user)) {
            return sessions.get(user);
        } else {
            Session session = new Session(user);
            sessions.put(user, session);
            return session;
        }
    }

    public void invalidateSession(String user) {
        if (sessions.containsKey(user)) {
            sessions.remove(user);
        }
    }

    private class Session {
        private String user;

        public java_00466_SessionManager_A07(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public void login(String password) {
            if (password.equals("correctpassword")) {
                // If password is correct, create a new Session object
                Session newSession = new Session(user);
                sessions.put(user, newSession);
            } else {
                // If password is incorrect, throw an exception
                throw new AuthFailureException("Incorrect password");
            }
        }
    }
}