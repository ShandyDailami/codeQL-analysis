import java.util.HashMap;
import java.util.Map;

public class java_18692_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_18692_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        sessions.put(userId, "SessionActive");
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public String getSessionStatus(String userId) {
        return sessions.get(userId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1"));

        sessionManager.endSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1"));
    }
}