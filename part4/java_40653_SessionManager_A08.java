import java.util.HashMap;
import java.util.UUID;

public class java_40653_SessionManager_A08 {
    private HashMap<UUID, String> sessionMap;

    public java_40653_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public UUID createSession(String user) {
        UUID sessionID = UUID.randomUUID();
        sessionMap.put(sessionID, user);
        return sessionID;
    }

    public String getUserFromSession(UUID sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            System.out.println("Invalid session ID");
            return null;
        }
    }
}