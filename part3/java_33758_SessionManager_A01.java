import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;

public class java_33758_SessionManager_A01 {
    private List<String> activeSessions;

    public java_33758_SessionManager_A01() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String userName) {
        activeSessions.add(userName);
    }

    public void endSession(String userName) throws RuntimeErrorException {
        if (!activeSessions.remove(userName)) {
            throw new RuntimeErrorException("User not found");
        }
    }

    public void checkActiveSessions() {
        if (activeSessions.isEmpty()) {
            System.out.println("No active sessions");
        } else {
            System.out.println("Active sessions: " + activeSessions);
        }
    }
}