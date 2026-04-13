import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class java_41032_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_41032_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(userName.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean validateSession(String sessionId, String expectedHash) {
        String hash = createSession(sessionId);
        return hash != null && hash.equals(expectedHash);
    }
}