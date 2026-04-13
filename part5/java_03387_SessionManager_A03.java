import java.util.ArrayList;
import java.util.List;

public class java_03387_SessionManager_A03 {
    private static List<String> activeSessions;

    public java_03387_SessionManager_A03() {
        activeSessions = new ArrayList<>();
    }

    public void openSession(String user) {
        activeSessions.add(user);
        System.out.println("Session opened for user: " + user);
    }

    public void closeSession(String user) {
        activeSessions.remove(user);
        System.out.println("Session closed for user: " + user);
    }

    public static boolean isSessionActive(String user) {
        return activeSessions.contains(user);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.openSession("User1");
        sessionManager.openSession("User2");

        System.out.println("Is User1 active session? " + sessionManager.isSessionActive("User1"));
        System.out.println("Is User2 active session? " + sessionManager.isSessionActive("User2"));

        sessionManager.closeSession("User1");

        System.out.println("Is User1 active session? " + sessionManager.isSessionActive("User1"));
    }
}