import java.util.ArrayList;
import java.util.HashMap;

public class java_26232_SessionManager_A01 {
    private HashMap<String, Object> sessionMap;
    private ArrayList<String> sessionIDs;

    public java_26232_SessionManager_A01() {
        sessionMap = new HashMap<>();
        sessionIDs = new ArrayList<>();
    }

    public void createSession(String sessionID) {
        if (!sessionIDs.contains(sessionID)) {
            sessionIDs.add(sessionID);
            sessionMap.put(sessionID, new HashMap<>());
        }
    }

    public void setSessionAttribute(String sessionID, String attributeName, Object attributeValue) {
        if (sessionIDs.contains(sessionID)) {
            sessionMap.get(sessionID).put(attributeName, attributeValue);
        }
    }

    public Object getSessionAttribute(String sessionID, String attributeName) {
        if (sessionIDs.contains(sessionID)) {
            return sessionMap.get(sessionID).get(attributeName);
        }
        return null;
    }

    public void destroySession(String sessionID) {
        if (sessionIDs.contains(sessionID)) {
            sessionIDs.remove(sessionID);
            sessionMap.remove(sessionID);
        }
    }
}