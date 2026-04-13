import java.util.*;

public class java_25951_SessionManager_A08 {
    private List<String> sessions;

    public java_25951_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public void addSession(String session) {
        sessions.add(session);
    }

    public void removeSession(String session) {
        sessions.remove(session);
    }

    public void cleanupSessions() {
        sessions.clear();
    }

    public List<String> getSessions() {
        return sessions;
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.addSession("Session1");
        sm.addSession("Session2");
        sm.addSession("Session3");
        System.out.println(sm.getSessions());
        sm.removeSession("Session2");
        System.out.println(sm.getSessions());
        sm.cleanupSessions();
        System.out.println(sm.getSessions());
    }
}