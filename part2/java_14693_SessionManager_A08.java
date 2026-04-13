import java.util.ArrayList;
import java.util.List;

public class java_14693_SessionManager_A08 {
    private List<String> sessions;
    private int currentIndex;

    public java_14693_SessionManager_A08() {
        sessions = new ArrayList<>();
        currentIndex = -1;
    }

    public String startSession() {
        currentIndex = (currentIndex + 1) % Integer.MAX_VALUE;
        String sessionId = Integer.toString(currentIndex);
        sessions.add(sessionId);
        return sessionId;
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String session1 = sessionManager.startSession();
        String session2 = sessionManager.startSession();
        sessionManager.endSession(session1);
        System.out.println(sessionManager.sessions);
    }
}