import java.util.LinkedList;
import java.util.List;

public class java_41681_SessionManager_A03 {
    private static List<String> sessionIDs = new LinkedList<>();

    public static void startSession() {
        String sessionID = UUID.randomUUID().toString();
        sessionIDs.add(sessionID);
        System.out.println("Started session with ID: " + sessionID);
    }

    public static void endSession(String sessionID) {
        if (sessionIDs.remove(sessionID)) {
            System.out.println("Ended session with ID: " + sessionID);
        } else {
            System.out.println("No active session with ID: " + sessionID);
        }
    }

    public static void main(String[] args) {
        SessionManager.startSession();
        SessionManager.startSession();
        SessionManager.endSession(SessionManager.getSessionID());
        SessionManager.endSession(SessionManager.getSessionID());
    }
}