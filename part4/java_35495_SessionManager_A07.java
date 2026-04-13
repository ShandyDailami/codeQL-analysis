import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_35495_SessionManager_A07 {

    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_35495_SessionManager_A07() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        userMap.put(username, encryptedPassword);
        return sessionId;
    }

    public String getSessionUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean validateSession(String sessionId, String password) {
        String encryptedPassword = userMap.get(sessionMap.get(sessionId));
        return encryptPassword(password).equals(encryptedPassword);
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return convertBytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString();
    }

    private String convertBytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}