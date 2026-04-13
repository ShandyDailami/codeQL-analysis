import java.util.Hashtable;
import java.util.UUID;

public class java_22054_SessionManager_A03 {
    private Hashtable<String, String> sessionTable;

    public java_22054_SessionManager_A03() {
        this.sessionTable = new Hashtable<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionTable.put(sessionId, "This is a session");
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionTable.containsKey(sessionId)) {
            return sessionTable.get(sessionId);
        } else {
            return "No session found with id: " + sessionId;
        }
    }

    public boolean destroySession(String sessionId) {
        if (sessionTable.containsKey(sessionId)) {
            sessionTable.remove(sessionId);
            return true;
        } else {
            return false;
        }
    }
}