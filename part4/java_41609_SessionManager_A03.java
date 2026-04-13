import java.util.HashMap;
import java.util.UUID;

public class java_41609_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_41609_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Creates a new session.
    public String createSession() {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, "Active");
        return sessionID;
    }

    // Gets a session.
    public String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }
}