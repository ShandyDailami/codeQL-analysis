import java.util.ArrayList;
import java.util.List;

public class java_37801_SessionManager_A08 {
    private List<String> sessions;

    public java_37801_SessionManager_A08() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(String session) {
        this.sessions.add(session);
    }

    public void removeSession(String session) {
        this.sessions.remove(session);
    }

    public void checkIntegrity() {
        if (this.sessions.size() == 0) {
            System.out.println("No sessions to check for integrity.");
            return;
        }

        // Simulating a security breach by checking a password field in each session
        for (String session : this.sessions) {
            if (session.endsWith("password")) {
                System.out.println("A security breach detected in session: " + session);
            }
        }
    }
}