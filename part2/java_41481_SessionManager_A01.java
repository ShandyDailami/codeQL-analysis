import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class java_41481_SessionManager_A01 {

    private List<String> activeSessions;

    public java_41481_SessionManager_A01() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String username) {
        activeSessions.add(username);
        System.out.println("Session started for user: " + username);
    }

    public void endSession(String username) {
        activeSessions.remove(username);
        System.out.println("Session ended for user: " + username);
    }

    public List<String> getActiveSessions() {
        // Return the active sessions in a safe manner
        return Collections.unmodifiableList(activeSessions);
    }
}