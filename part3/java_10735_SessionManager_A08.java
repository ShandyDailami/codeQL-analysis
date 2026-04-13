import java.util.ArrayList;
import java.util.List;

public class java_10735_SessionManager_A08 {
    private List<String> sessions;

    public java_10735_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void startSession(String user) {
        if (sessions.size() < 5) {
            sessions.add(user);
            System.out.println("Started session for user: " + user);
        } else {
            System.out.println("Cannot start new session for user: " + user);
        }
    }

    public void endSession(String user) {
        if (sessions.contains(user)) {
            sessions.remove(user);
            System.out.println("Ended session for user: " + user);
        } else {
            System.out.println("User: " + user + " does not have a session to end.");
        }
    }

    public void checkSession(String user) {
        if (sessions.contains(user)) {
            System.out.println("User: " + user + " has a session active.");
        } else {
            System.out.println("User: " + user + " does not have a session.");
        }
    }

    public void checkSessionLimit() {
        System.out.println("Active sessions: " + sessions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("User1");
        manager.startSession("User2");
        manager.startSession("User3");
        manager.startSession("User4");
        manager.startSession("User5");
        manager.startSession("User6"); // Cannot start new session for user: User6

        manager.checkSession("User1");
        manager.checkSession("User2");
        manager.checkSession("User4");
        manager.checkSession("User6"); // User does not have a session

        manager.endSession("User1");
        manager.endSession("User2");
        manager.endSession("User4");
        manager.endSession("User5"); // User does not have a session to end

        manager.checkSession("User1"); // User does not have a session
        manager.checkSession("User2");
        manager.checkSession("User3");
        manager.checkSession("User4");
        manager.checkSessionLimit(); // Active sessions: 3
    }
}