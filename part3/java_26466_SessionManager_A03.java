import java.util.ArrayList;
import java.util.List;

public class java_26466_SessionManager_A03 {
    private List<String> activeSessions;

    public java_26466_SessionManager_A03() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String username) {
        activeSessions.add(username);
    }

    public void endSession(String username) {
        activeSessions.remove(username);
    }

    public List<String> getActiveSessions() {
        return activeSessions;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("User1");
        manager.startSession("User2");
        manager.startSession("User3");

        System.out.println("Active sessions: " + manager.getActiveSessions());

        manager.endSession("User2");

        System.out.println("Active sessions after ending session User2: " + manager.getActiveSessions());
    }
}