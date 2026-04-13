import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_37008_SessionManager_A03 {

    // Session Manager class to handle session management

    private static SessionManager instance = null;

    private MessageDigest digest;

    // Singleton instance of SessionManager
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private java_37008_SessionManager_A03() {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getSessionId(String userName, String password) {
        // Add password hashing mechanism here
        byte[] hash = digest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}