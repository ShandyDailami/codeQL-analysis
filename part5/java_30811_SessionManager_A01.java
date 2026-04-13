import java.util.HashMap;
import java.util.Map;

public class java_30811_SessionManager_A01 {
    // private static attributes for the session map
    private Map<String, String> sessionMap;

    // constructor
    public java_30811_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // method to create a new session
    public String createSession(String userName) {
        // create a unique session key
        String sessionKey = UUID.randomUUID().toString();

        // add user to session map
        sessionMap.put(sessionKey, userName);

        return sessionKey;
    }

    // method to get the user for a given session
    public String getUser(String sessionKey) {
        // validate the session key
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey);
        } else {
            return null;
        }
    }

    // method to invalidate a session
    public void invalidateSession(String sessionKey) {
        // remove the session from the session map
        sessionMap.remove(sessionKey);
    }
}