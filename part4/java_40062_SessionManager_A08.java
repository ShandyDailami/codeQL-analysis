import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class java_40062_SessionManager_A08 {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static SecureRandom random = new SecureRandom();
    private List<String> activeSessions = new ArrayList<>();

    public String createSession() {
        String session;
        do {
            session = generateRandomString(20);
        } while (activeSessions.contains(session));

        activeSessions.add(session);
        return session;
    }

    public void endSession(String session) {
        activeSessions.remove(session);
    }

    public boolean isSessionActive(String session) {
        return activeSessions.contains(session);
    }

    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        String session1 = sessionManager.createSession();
        System.out.println("Session 1: " + session1);
        System.out.println("Active Sessions: " + sessionManager.activeSessions.toString());

        String session2 = sessionManager.createSession();
        System.out.println("Session 2: " + session2);
        System.out.println("Active Sessions: " + sessionManager.activeSessions.toString());

        sessionManager.endSession(session1);
        System.out.println("Active Sessions After Session 1 Ended: " + sessionManager.activeSessions.toString());

        // try to end non-existing session
        sessionManager.endSession("NonExistingSession");
    }
}