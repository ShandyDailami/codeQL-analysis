import java.util.HashMap;
import java.util.Map;

public class java_21030_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_21030_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, user);
        System.out.println("Started session: " + sessionId + " for user: " + user);
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        String user = sessions.get(sessionId);
        sessions.remove(sessionId);
        System.out.println("Ended session: " + sessionId + " for user: " + user);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("Alice");
        manager.startSession("Bob");

        System.out.println("Alice: " + manager.getUser(String.valueOf(System.currentTimeMillis())));
        System.out.println("Bob: " + manager.getUser(String.valueOf(System.currentTimeMillis())));

        manager.endSession(String.valueOf(System.currentTimeMillis()));
        System.out.println("Alice: " + manager.getUser(String.valueOf(System.currentTimeMillis())));
    }
}