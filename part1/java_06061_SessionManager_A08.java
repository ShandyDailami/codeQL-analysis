import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_06061_SessionManager_A08 {

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession();
        sm.endSession();
    }

    private String generateSessionKey() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(System.currentTimeMillis() + System.nanoTime() + "session-key");
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void startSession() {
        String sessionKey = generateSessionKey();
        System.out.println("Starting session with key: " + sessionKey);
        // perform integrity check here, but let's assume it's successful
        // in a real-world application, we would also check the integrity of the session
        // in a database or another persistent storage
    }

    private void endSession() {
        String sessionKey = generateSessionKey();
        System.out.println("Ending session with key: " + sessionKey);
        // perform integrity check here, but let's assume it's successful
        // in a real-world application, we would also check the integrity of the session
        // in a database or another persistent storage
    }
}