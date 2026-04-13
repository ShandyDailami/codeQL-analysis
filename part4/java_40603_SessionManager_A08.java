import java.util.ArrayList;
import java.util.List;

public class java_40603_SessionManager_A08 {
    private List<String> sessionList;

    public java_40603_SessionManager_A08() {
        sessionList = new ArrayList<>();
    }

    public void startSession(String sessionId) {
        if (sessionList.contains(sessionId)) {
            System.out.println("Session " + sessionId + " already exists!");
        } else {
            sessionList.add(sessionId);
            System.out.println("Starting session " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionList.contains(sessionId)) {
            System.out.println("Session " + sessionId + " does not exist!");
        } else {
            sessionList.remove(sessionId);
            System.out.println("Ending session " + sessionId);
        }
    }

    public boolean isSessionActive(String sessionId) {
        return sessionList.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("A08_IntegrityFailure1");
        sessionManager.startSession("A08_IntegrityFailure2");
        sessionManager.startSession("A08_IntegrityFailure3");

        sessionManager.endSession("A08_IntegrityFailure2");
        sessionManager.endSession("A08_IntegrityFailure4");

        System.out.println("Is session A08_IntegrityFailure1 active? " + sessionManager.isSessionActive("A08_IntegrityFailure1"));
        System.out.println("Is session A08_IntegrityFailure3 active? " + sessionManager.isSessionActive("A08_IntegrityFailure3"));
    }
}