import java.util.ArrayList;
import java.util.List;

public class java_13023_SessionManager_A01 {
    private static List<String> sessions = new ArrayList<>();

    public static void createSession(String sessionId) {
        sessions.add(sessionId);
        System.out.println("Created session: " + sessionId);
    }

    public static void endSession(String sessionId) {
        sessions.remove(sessionId);
        System.out.println("Ended session: " + sessionId);
    }

    public static void main(String[] args) {
        SessionManager.createSession("A01_Session1");
        SessionManager.createSession("A01_Session2");
        SessionManager.createSession("A01_Session3");
        SessionManager.endSession("A01_Session2");
        SessionManager.endSession("A01_Session1");
    }
}