import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_38374_SessionManager_A08 {

    private Map<String, String> sessions;
    private SecureRandom random;

    public java_38374_SessionManager_A08() {
        sessions = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession(String username) {
        String token = createRandomToken();
        sessions.put(token, username);
        return token;
    }

    public String getUsername(String token) {
        return sessions.get(token);
    }

    public void deleteSession(String token) {
        sessions.remove(token);
    }

    private String createRandomToken() {
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String session = sessionManager.createSession("John");
        System.out.println("Created session: " + session);
        String username = sessionManager.getUsername(session);
        System.out.println("Username: " + username);
        sessionManager.deleteSession(session);
        System.out.println("Deleted session: " + session);
    }
}