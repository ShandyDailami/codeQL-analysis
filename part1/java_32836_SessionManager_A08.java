import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class java_32836_SessionManager_A08 {

    // This is a HashMap which stores userIDs and their corresponding sessions
    private Map<String, Session> sessionMap;

    public java_32836_SessionManager_A08() {
        sessionMap = new HashMap<String, Session>();
    }

    // This class represents a session
    public class Session {
        private String userID;
        private Date creationTime;
        private Date expirationTime;

        public java_32836_SessionManager_A08(String userID, Date creationTime, Date expirationTime) {
            this.userID = userID;
            this.creationTime = creationTime;
            this.expirationTime = expirationTime;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public Date getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(Date creationTime) {
            this.creationTime = creationTime;
        }

        public Date getExpirationTime() {
            return expirationTime;
        }

        public void setExpirationTime(Date expirationTime) {
            this.expirationTime = expirationTime;
        }
    }

    // This method creates a new session
    public String createSession(String userID) {
        Date creationTime = new Date();
        Date expirationTime = new Date();
        expirationTime.setTime(creationTime.getTime() + (1000 * 60 * 60)); // 1 hour

        Session session = new Session(userID, creationTime, expirationTime);
        sessionMap.put(userID, session);

        return userID;
    }

    // This method checks if the session is valid
    public boolean isValidSession(String userID) {
        if (!sessionMap.containsKey(userID)) {
            return false;
        }

        Session session = sessionMap.get(userID);

        // Check if the session has expired
        if (session.getExpirationTime().before(new Date())) {
            return false;
        }

        return true;
    }
}