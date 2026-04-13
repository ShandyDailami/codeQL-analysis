import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class java_13274_SessionManager_A08 {
    private HashMap<String, String> sessions;
    private HashMap<String, String> passwords;

    public java_13274_SessionManager_A08() {
        sessions = new HashMap<>();
        passwords = new HashMap<>();
    }

    public String createSession(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        passwords.put(username, encryptedPassword);

        String sessionId = generateSessionId(username);
        sessions.put(sessionId, username);

        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        String username = sessions.get(sessionId);
        sessions.remove(sessionId);
        passwords.remove(username);
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateSessionId(String username) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(username.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}