import java.sql.*;
import java.util.*;

public class java_13099_SessionManager_A03 {
    private HashMap<String, Session> sessions = new HashMap<>();

    public Session createSession() {
        String sessionID = UUID.randomUUID().toString();
        Session session = new Session(sessionID);
        sessions.put(sessionID, session);
        return session;
    }

    public void endSession(String sessionID) {
        sessions.remove(sessionID);
    }

    private class Session {
        private String sessionID;

        public java_13099_SessionManager_A03(String sessionID) {
            this.sessionID = sessionID;
        }

        public String getSessionID() {
            return sessionID;
        }
    }
}