import java.util.HashMap;
import java.util.Map;

public class java_34634_SessionManager_A01 {
    // The session map uses UserID as key and Session object as value
    private Map<Integer, Session> sessionMap;
    private int sessionIDCounter;

    public java_34634_SessionManager_A01() {
        sessionMap = new HashMap<>();
        sessionIDCounter = 0;
    }

    public Session createSession(User user) {
        Session newSession = new Session(user, this.sessionIDCounter);
        sessionMap.put(this.sessionIDCounter, newSession);
        this.sessionIDCounter++;
        return newSession;
    }

    public Session getSession(int sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(int sessionID) {
        sessionMap.remove(sessionID);
    }

    public class Session {
        private User user;
        private int sessionID;

        public java_34634_SessionManager_A01(User user, int sessionID) {
            this.user = user;
            this.sessionID = sessionID;
        }

        public User getUser() {
            return user;
        }

        public int getSessionID() {
            return sessionID;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void setSessionID(int sessionID) {
            this.sessionID = sessionID;
        }
    }

    public class User {
        private String name;

        public java_34634_SessionManager_A01(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}