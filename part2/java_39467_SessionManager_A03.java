import java.util.ArrayList;

public class java_39467_SessionManager_A03 {

    private ArrayList<String> sessions;
    private String currentSession;

    public java_39467_SessionManager_A03() {
        sessions = new ArrayList<>();
        currentSession = null;
    }

    public void addSession(String session) {
        sessions.add(session);
    }

    public void removeSession(String session) {
        sessions.remove(session);
    }

    public void setCurrentSession(String session) {
        currentSession = session;
    }

    public String getCurrentSession() {
        return currentSession;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("Session1");
        sessionManager.addSession("Session2");
        sessionManager.addSession("Session3");

        sessionManager.setCurrentSession("Session1");

        System.out.println("Current session: " + sessionManager.getCurrentSession());
    }
}