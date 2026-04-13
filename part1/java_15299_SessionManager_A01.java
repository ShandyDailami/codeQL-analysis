import java.util.HashMap;
import java.util.Map;

public class java_15299_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_15299_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userID, String sessionID) {
        sessionMap.put(userID, sessionID);
    }

    public String getSession(String userID) {
        return sessionMap.get(userID);
    }

    public void deleteSession(String userID) {
        sessionMap.remove(userID);
    }
}