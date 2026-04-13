import java.util.ArrayList;
import java.util.List;

public class java_27274_SessionManager_A08 {
    private static List<String> activeSessions = new ArrayList<>();

    public static void startSession(String user) {
        activeSessions.add(user);
    }

    public static void endSession(String user) {
        activeSessions.remove(user);
    }

    public static boolean isSessionActive(String user) {
        return activeSessions.contains(user);
    }

    public static void checkIntegrity() {
        if (activeSessions.isEmpty()) {
            System.out.println("No active sessions. Everything is up to date.");
            return;
        }

        for (String user : activeSessions) {
            System.out.printf("Session for user %s is inactive. Please check the system.\n", user);
        }
    }
}