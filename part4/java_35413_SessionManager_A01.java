import java.util.HashMap;

public class java_35413_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_35413_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionID) {
        if (sessions.containsKey(sessionID)) {
            return "Session already exists";
        } else {
            sessions.put(sessionID, new Session(sessionID));
            return "Session created";
        }
    }

    public Object getSessionData(String sessionID) {
        if (sessions.containsKey(sessionID)) {
            return sessions.get(sessionID).getData();
        } else {
            return "Session does not exist";
        }
    }

    public String updateSessionData(String sessionID, Object data) {
        if (sessions.containsKey(sessionID)) {
            sessions.get(sessionID).setData(data);
            return "Session data updated";
        } else {
            return "Session does not exist";
        }
    }

    public String deleteSession(String sessionID) {
        if (sessions.containsKey(sessionID)) {
            sessions.remove(sessionID);
            return "Session deleted";
        } else {
            return "Session does not exist";
        }
    }
}

class Session {
    private String sessionID;
    private Object data;

    public java_35413_SessionManager_A01(String sessionID) {
        this.sessionID = sessionID;
        this.data = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}