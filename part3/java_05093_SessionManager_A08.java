import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;

public class java_05093_SessionManager_A08 {
    private List<UserSession> sessions;
    private int sessionIdCounter;

    public java_05093_SessionManager_A08() {
        sessions = new ArrayList<>();
        sessionIdCounter = 0;
    }

    public UserSession createSession(String username) {
        UserSession newSession = new UserSession(username, ++sessionIdCounter);
        sessions.add(newSession);
        return newSession;
    }

    public UserSession getSession(int sessionId) {
        for (UserSession session : sessions) {
            if (session.getId() == sessionId) {
                return session;
            }
        }
        throw new RuntimeErrorException(new Throwable("Session not found with id " + sessionId));
    }

    public void deleteSession(int sessionId) {
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getId() == sessionId) {
                sessions.remove(i);
                return;
            }
        }
        throw new RuntimeErrorException(new Throwable("Session not found with id " + sessionId));
    }

    public class UserSession {
        private String username;
        private int id;

        public java_05093_SessionManager_A08(String username, int id) {
            this.username = username;
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}