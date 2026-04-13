import java.util.ArrayList;
import java.util.List;

public class java_31908_SessionManager_A08 {
    private List<Session> sessions;

    public java_31908_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void addSession(String userName, boolean isActive) {
        Session session = new Session(userName, isActive);
        sessions.add(session);
    }

    public boolean isActiveSessionExists(String userName) {
        for (Session session : sessions) {
            if (session.isActive() && session.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void deactivateSession(String userName) {
        for (Session session : sessions) {
            if (session.getUserName().equals(userName)) {
                session.setActive(false);
                break;
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("Alice", true);
        sessionManager.addSession("Bob", true);
        sessionManager.addSession("Charlie", true);

        System.out.println(sessionManager.isActiveSessionExists("Alice")); // Should print: true
        System.out.println(sessionManager.isActiveSessionExists("Dave")); // Should print: false

        sessionManager.deactivateSession("Bob");

        System.out.println(sessionManager.isActiveSessionExists("Bob")); // Should print: false
    }
}

class Session {
    private String userName;
    private boolean isActive;

    public java_31908_SessionManager_A08(String userName, boolean isActive) {
        this.userName = userName;
        this.isActive = isActive;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}