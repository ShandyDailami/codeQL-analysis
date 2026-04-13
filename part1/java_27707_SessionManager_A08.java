import java.util.ArrayList;
import java.util.List;

public class java_27707_SessionManager_A08 {
    private List<String> sessionList;

    public java_27707_SessionManager_A08() {
        this.sessionList = new ArrayList<>();
    }

    public void addSession(String session) {
        if (session != null && session.length() > 0) {
            sessionList.add(session);
        }
    }

    public List<String> getAllSessions() {
        return sessionList;
    }

    public void removeSession(String session) {
        if (session != null && session.length() > 0) {
            sessionList.remove(session);
        }
    }

    public boolean isSessionExist(String session) {
        return sessionList.contains(session);
    }

    public void clearSessions() {
        sessionList.clear();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("Session1");
        sessionManager.addSession("Session2");
        sessionManager.addSession("Session3");

        System.out.println("All sessions: " + sessionManager.getAllSessions());

        sessionManager.removeSession("Session2");

        System.out.println("All sessions after removing Session2: " + sessionManager.getAllSessions());

        System.out.println("Does Session1 exist: " + sessionManager.isSessionExist("Session1"));
        System.out.println("Does Session4 exist: " + sessionManager.isSessionExist("Session4"));

        sessionManager.clearSessions();

        System.out.println("All sessions after clearing: " + sessionManager.getAllSessions());
    }
}