import java.util.ArrayList;
import java.util.List;

public class java_13970_SessionManager_A03 {

    private List<String> sessions;

    public java_13970_SessionManager_A03() {
        sessions = new ArrayList<>();
    }

    public void startSession(String user) {
        sessions.add(user);
    }

    public void endSession(String user) {
        sessions.remove(user);
    }

    public List<String> getActiveSessions() {
        return sessions;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("User1");
        sessionManager.startSession("User2");
        sessionManager.startSession("User3");

        System.out.println("Active Sessions: " + sessionManager.getActiveSessions());

        sessionManager.endSession("User2");

        System.out.println("Active Sessions: " + sessionManager.getActiveSessions());
    }
}