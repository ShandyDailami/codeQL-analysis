import java.util.concurrent.ConcurrentHashMap;

public class java_02692_SessionManager_A01 {
    // ConcurrentHashMap is used to hold session IDs and sessions
    private ConcurrentHashMap<String, Session> sessions = new ConcurrentHashMap<>();

    // Session class
    private class Session {
        private String sessionID;

        public java_02692_SessionManager_A01(String sessionID) {
            this.sessionID = sessionID;
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }
    }

    public String createSession(String sessionID) {
        if (sessions.containsKey(sessionID)) {
            return "Session with ID " + sessionID + " already exists";
        } else {
            sessions.put(sessionID, new Session(sessionID));
            return "Created session with ID " + sessionID;
        }
    }

    public String getSession(String sessionID) {
        if (sessions.containsKey(sessionID)) {
            return "Session with ID " + sessionID + " found";
        } else {
            return "No session with ID " + sessionID + " exists";
        }
    }

    public String deleteSession(String sessionID) {
        if (sessions.containsKey(sessionID)) {
            sessions.remove(sessionID);
            return "Deleted session with ID " + sessionID;
        } else {
            return "No session with ID " + sessionID + " exists";
        }
    }
}