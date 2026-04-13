import java.util.*;

public class java_09676_SessionManager_A08 {

    private static List<String> activeSessions = new ArrayList<>();

    public static void main(String[] args) {
        createSession("Session1");
        createSession("Session2");
        createSession("Session3");

        try {
            removeSession("Session2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            removeNonExistentSession("NonExistentSession");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createSession(String sessionId) {
        activeSessions.add(sessionId);
        System.out.println("Created session: " + sessionId);
    }

    public static void removeSession(String sessionId) throws Exception {
        if (!activeSessions.contains(sessionId)) {
            throw new Exception("Session not found!");
        }

        activeSessions.remove(sessionId);
        System.out.println("Removed session: " + sessionId);
    }

    public static void removeNonExistentSession(String sessionId) throws Exception {
        removeSession(sessionId);
    }

}