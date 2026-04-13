import java.util.HashMap;
import java.util.Map;

public class java_36073_SessionManager_A03 {
    private Map<String, Session> sessionMap;

    public java_36073_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session with id " + sessionId + " already exists!";
        }
        sessionMap.put(sessionId, new Session(sessionId));
        return "Session created with id " + sessionId;
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists!";
        }
        Session session = sessionMap.get(sessionId);
        return "Session " + sessionId + " data: " + session.getData();
    }

    public String updateSession(String sessionId, String newData) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists!";
        }
        Session session = sessionMap.get(sessionId);
        session.setData(newData);
        return "Session " + sessionId + " updated with new data: " + newData;
    }

    public String deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists!";
        }
        sessionMap.remove(sessionId);
        return "Session " + sessionId + " deleted!";
    }
}

class Session {
    private String sessionId;
    private String data;

    public java_36073_SessionManager_A03(String sessionId) {
        this.sessionId = sessionId;
        this.data = "Initial data";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}