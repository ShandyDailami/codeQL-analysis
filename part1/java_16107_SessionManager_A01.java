import java.security.SecureRandom;

public class java_16107_SessionManager_A01 {
    private static final int MAX_SIZE = 10000;
    private static final SecureRandom random = new SecureRandom();

    private int count = 0;
    private String[] sessions = new String[MAX_SIZE];

    public String createSession() {
        String sessionId = "";
        if (count < MAX_SIZE) {
            // Create a random session ID
            for (int i = 0; i < 20; i++) {
                sessionId += random.nextInt(10);
            }
            sessions[count++] = sessionId;
        } else {
            System.out.println("Session limit exceeded. Cannot create a new session.");
        }
        return sessionId;
    }

    public void destroySession(String sessionId) {
        // Find the session in the array and remove it
        for (int i = 0; i < count; i++) {
            if (sessions[i].equals(sessionId)) {
                for (int j = i; j < count - 1; j++) {
                    sessions[j] = sessions[j + 1];
                }
                count--;
                System.out.println("Session " + sessionId + " destroyed.");
                return;
            }
        }
        System.out.println("Session " + sessionId + " not found.");
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a few sessions
        for (int i = 0; i < 5; i++) {
            manager.createSession();
        }

        // Destroy a session
        manager.destroySession("1234567890");
    }
}