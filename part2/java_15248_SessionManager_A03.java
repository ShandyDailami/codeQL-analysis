import java.util.ArrayList;
import java.util.List;

public class java_15248_SessionManager_A03 {
    private List<String> sessionList;
    private int sessionCount;

    public java_15248_SessionManager_A03() {
        sessionList = new ArrayList<>();
        sessionCount = 0;
    }

    public String createSession() {
        sessionCount++;
        String sessionId = "SESSION_" + sessionCount;
        sessionList.add(sessionId);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessionList.remove(sessionId);
    }

    public void deleteAllSessions() {
        sessionList.clear();
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String session1 = sessionManager.createSession();
        String session2 = sessionManager.createSession();
        String session3 = sessionManager.createSession();

        sessionManager.deleteSession(session2);

        System.out.println("Session Count: " + sessionManager.getSessionCount());
    }
}