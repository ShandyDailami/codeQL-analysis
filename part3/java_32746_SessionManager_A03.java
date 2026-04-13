import java.util.ArrayList;
import java.util.List;

public class java_32746_SessionManager_A03 {
    private List<String> activeSessions;

    public java_32746_SessionManager_A03() {
        activeSessions = new ArrayList<>();
    }

    public void createSession(String user) {
        activeSessions.add(user);
    }

    public void deleteSession(String user) {
        activeSessions.remove(user);
    }

    public void checkSession(String user) {
        if (activeSessions.contains(user)) {
            System.out.println("Session exists for user: " + user);
        } else {
            System.out.println("No active session for user: " + user);
        }
    }

    public int getActiveSessionCount() {
        return activeSessions.size();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("User1");
        sessionManager.createSession("User2");
        sessionManager.createSession("User3");

        sessionManager.checkSession("User1"); // Expected output: "Session exists for user: User1"
        sessionManager.checkSession("User4"); // Expected output: "No active session for user: User4"

        System.out.println("Active session count: " + sessionManager.getActiveSessionCount()); // Expected output: "Active session count: 3"

        sessionManager.deleteSession("User2");
        sessionManager.checkSession("User2"); // Expected output: "No active session for user: User2"

        System.out.println("Active session count: " + sessionManager.getActiveSessionCount()); // Expected output: "Active session count: 2"
    }
}