import java.util.ArrayList;
import java.util.List;

public class java_30336_SessionManager_A03 {
    private List<String> sessionList;

    public java_30336_SessionManager_A03() {
        sessionList = new ArrayList<>();
    }

    // method to start a new session
    public void startSession() {
        String sessionId = Integer.toString(sessionList.size());
        sessionList.add(sessionId);
    }

    // method to end a session
    public void endSession(String sessionId) {
        if (sessionList.contains(sessionId)) {
            sessionList.remove(sessionId);
        } else {
            System.out.println("No such session found!");
        }
    }

    // method to validate a session
    public void validateSession(String sessionId) {
        if (sessionList.contains(sessionId)) {
            System.out.println("Session: " + sessionId + " is valid.");
        } else {
            System.out.println("No such session found!");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.startSession();
        sm.startSession();
        sm.startSession();

        sm.validateSession("0");
        sm.validateSession("1");
        sm.validateSession("2");

        sm.endSession("1");

        sm.validateSession("1");
        sm.validateSession("2");
    }
}