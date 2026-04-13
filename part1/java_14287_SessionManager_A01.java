import java.util.ArrayList;
import java.util.List;

public class java_14287_SessionManager_A01 {
    private List<String> sessions = new ArrayList<>();
    private int sessionIndex = 0;

    public void startSession() {
        sessions.add(Integer.toString(sessionIndex++));
    }

    public void endSession() {
        if (sessions.isEmpty()) {
            throw new IllegalStateException("No active session found.");
        } else {
            sessions.remove(sessions.size() - 1);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessions.contains(sessionId)) {
            sessions.remove(sessionId);
        } else {
            throw new IllegalStateException("Invalid session ID.");
        }
    }

    public void changeSessionOwner(String sessionId, String newOwner) {
        if (sessions.contains(sessionId)) {
            for (int i = 0; i < sessions.size(); i++) {
                if (sessions.get(i).equals(sessionId)) {
                    sessions.set(i, newOwner);
                    break;
                }
            }
        } else {
            throw new IllegalStateException("Invalid session ID.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession();
        sessionManager.startSession();
        sessionManager.startSession();

        sessionManager.changeSessionOwner(sessionManager.sessions.get(0), "New Owner");
        sessionManager.deleteSession(sessionManager.sessions.get(1));
        sessionManager.endSession();
        sessionManager.endSession();
    }
}