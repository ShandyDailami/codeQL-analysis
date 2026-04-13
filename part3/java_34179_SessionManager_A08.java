import java.util.HashMap;
import java.util.Map;

public class java_34179_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_34179_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(userID, sessionID);
        return sessionID;
    }

    public String getSession(String userID) {
        return sessionMap.get(userID);
    }

    public void destroySession(String sessionID) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionID)) {
                sessionMap.remove(entry.getKey());
                break;
            }
        }
    }
}