import java.util.ArrayList;
import java.util.List;

public class java_07031_SessionManager_A01 {
    private List<String> sessions;
    private int sessionCount;

    public java_07031_SessionManager_A01() {
        this.sessions = new ArrayList<>();
        this.sessionCount = 0;
    }

    public void openSession() {
        if (this.sessionCount < 5) {
            this.sessions.add("Session " + (this.sessionCount + 1));
            this.sessionCount++;
        } else {
            System.out.println("Cannot open more sessions. Max limit reached.");
        }
    }

    public void closeSession(int sessionId) {
        if (sessionId >= 1 && sessionId <= this.sessionCount) {
            this.sessions.remove(sessionId - 1);
            this.sessionCount--;
        } else {
            System.out.println("Invalid session ID.");
        }
    }

    public void checkSession(int sessionId) {
        if (sessionId >= 1 && sessionId <= this.sessionCount) {
            System.out.println("Session " + sessionId + " is active.");
        } else {
            System.out.println("Invalid session ID.");
        }
    }

    public static void main(String[] args) {
        LegacySessionManager manager = new LegacySessionManager();

        manager.openSession();
        manager.openSession();
        manager.openSession();
        manager.openSession();
        manager.openSession();
        manager.openSession();

        manager.checkSession(1);
        manager.checkSession(2);

        manager.closeSession(1);

        manager.checkSession(1);
    }
}