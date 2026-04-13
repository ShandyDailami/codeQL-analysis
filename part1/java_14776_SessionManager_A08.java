import java.util.HashMap;
import java.util.Map;

public class java_14776_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_14776_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) throws A08_IntegrityFailure {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new A08_IntegrityFailure("Invalid Session Id");
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Add more methods to manage other session operations as needed

}