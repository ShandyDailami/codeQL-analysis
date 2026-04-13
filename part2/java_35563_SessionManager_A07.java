import java.security.SecureRandom;
import java.util.HashMap;

public class java_35563_SessionManager_A07 {
    private HashMap<String, String> sessionData;
    private SecureRandom secureRandom;

    public java_35563_SessionManager_A07() {
        sessionData = new HashMap<>();
        secureRandom = new SecureRandom();
    }

    public String createSession() {
        String sessionId;
        do {
            sessionId = generateRandomAlphanumericString(24);
        } while (sessionData.containsValue(sessionId));

        sessionData.put(sessionId, "");

        return sessionId;
    }

    public String getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void updateSessionData(String sessionId, String data) {
        sessionData.replace(sessionId, data);
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    private String generateRandomAlphanumericString(int length) {
        String alphanumericChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(alphanumericChars.charAt(secureRandom.nextInt(alphanumericChars.length())));
        }
        return sb.toString();
    }
}