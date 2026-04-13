import java.util.ArrayList;
import java.util.List;

public class java_38033_SessionManager_A03 {
    private List<String> activeSessions = new ArrayList<>();

    public void openSession(String user) {
        activeSessions.add(user);
        System.out.println("Opened session for user: " + user);
    }

    public void closeSession(String user) {
        if (activeSessions.contains(user)) {
            activeSessions.remove(user);
            System.out.println("Closed session for user: " + user);
        } else {
            System.out.println("No active session for user: " + user);
        }
    }

    public void checkSession(String user) {
        if (activeSessions.contains(user)) {
            System.out.println("Active session for user: " + user);
        } else {
            System.out.println("No active session for user: " + user);
        }
    }
}