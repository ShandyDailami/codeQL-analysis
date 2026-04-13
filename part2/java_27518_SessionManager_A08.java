import java.util.ArrayList;
import java.util.List;

public class java_27518_SessionManager_A08 {
    private List<Session> sessions;

    public java_27518_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void openSession(int sessionId) {
        sessions.add(new Session(sessionId));
    }

    public void closeSession(int sessionId) {
        for (Session session : sessions) {
            if (session.getId() == sessionId) {
                sessions.remove(session);
                break;
            }
        }
    }

    private class Session {
        private int id;

        public java_27518_SessionManager_A08(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.openSession(1);
        sessionManager.openSession(2);

        sessionManager.closeSession(1);

        sessionManager.openSession(3);
    }
}