import java.util.ArrayList;
import java.util.List;

public class java_29678_SessionManager_A01 {
    private List<Session> sessions;
    private int sessionCount;

    public java_29678_SessionManager_A01() {
        sessions = new ArrayList<>();
        sessionCount = 0;
    }

    public Session startSession() {
        Session session = new Session();
        sessions.add(session);
        sessionCount++;
        return session;
    }

    public void endSession(Session session) {
        sessions.remove(session);
        sessionCount--;
    }

    public int getSessionCount() {
        return sessionCount;
    }
}

class Session {
    private boolean isActive;

    public java_29678_SessionManager_A01() {
        isActive = true;
    }

    public void closeSession() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}