import java.util.HashMap;
import java.util.Map;

public class java_21058_SessionManager_A07 {

    private Map<String, String> storage;

    public java_21058_SessionManager_A07() {
        storage = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + "_" + System.currentTimeMillis();
        storage.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return storage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        storage.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionId = sm.createSession("alice");
        System.out.println("Created session: " + sessionId);
        String user = sm.getUser(sessionId);
        System.out.println("Retrieved user: " + user);
        sm.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}