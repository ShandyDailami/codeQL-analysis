import java.util.HashMap;
import java.util.Map;

public class java_08296_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_08296_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(String userID, int accessLevel) {
        if (accessLevel < 0 || accessLevel > 2) {
            throw new IllegalArgumentException("Invalid access level: " + accessLevel);
        }
        sessions.put(userID, new Session(userID, accessLevel));
    }

    public Session getSession(String userID) {
        return sessions.get(userID);
    }

    public void removeSession(String userID) {
        sessions.remove(userID);
    }

    public static class Session {
        private String userID;
        private int accessLevel;

        public java_08296_SessionManager_A01(String userID, int accessLevel) {
            this.userID = userID;
            this.accessLevel = accessLevel;
        }

        public String getUserID() {
            return userID;
        }

        public int getAccessLevel() {
            return accessLevel;
        }
    }
}