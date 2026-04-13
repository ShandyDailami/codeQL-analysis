import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class java_07151_SessionManager_A07 {
    private HashMap<String, String> sessionData;
    private HashMap<String, String> expectedData;
    private MessageDigest md;

    public java_07151_SessionManager_A07() {
        sessionData = new HashMap<>();
        expectedData = new HashMap<>();

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void addSession(String sessionId, String data) {
        byte[] hash = md.digest(data.getBytes());
        sessionData.put(sessionId, bytesToHex(hash));
        expectedData.put(sessionId, data);
    }

    public String getSession(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            return null;
        }
    }

    public boolean validateSession(String sessionId, String data) {
        byte[] hash = md.digest(data.getBytes());
        return sessionData.containsKey(sessionId) && sessionData.get(sessionId).equals(bytesToHex(hash));
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}