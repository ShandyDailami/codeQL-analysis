public class java_24375_SessionManager_A01 {
    private Session[] sessions;
    private int currentIndex;

    public java_24375_SessionManager_A01(int size) {
        sessions = new Session[size];
        currentIndex = 0;
    }

    public Session getSession() {
        if (currentIndex < sessions.length) {
            sessions[currentIndex] = new Session();
            return sessions[currentIndex++];
        } else {
            throw new RuntimeException("No more sessions available");
        }
    }

    public void closeSession(Session session) {
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] == session) {
                sessions[i] = null;
                currentIndex--;
                return;
            }
        }
        throw new RuntimeException("Session not found");
    }

    public static class Session {
        // Session class would contain fields and methods related to the session
    }
}