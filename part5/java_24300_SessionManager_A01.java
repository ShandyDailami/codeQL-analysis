import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_24300_SessionManager_A01 {
    private Map<String, String> sessionData;
    private Map<String, String> storedSessions;

    public java_24300_SessionManager_A01() {
        sessionData = new HashMap<>();
        storedSessions = new HashMap<>();
    }

    public String createSession(String username, String password) {
        // Hash password with SHA-256 algorithm
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            String hashPassword = hexString.toString();

            // Store session data
            sessionData.put(username, hashPassword);
            return hashPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSession(String username, String password) {
        // Check if session data is stored
        if(storedSessions.containsKey(username)) {
            if(storedSessions.get(username).equals(password)) {
                return storedSessions.get(username);
            }
        }

        // If not, try to authenticate user
        if(sessionData.containsKey(username)) {
            if(sessionData.get(username).equals(password)) {
                return sessionData.get(username);
            }
        }

        return null;
    }

    public void storeSession(String sessionId, String username) {
        // Store session data
        storedSessions.put(username, sessionId);
    }
}