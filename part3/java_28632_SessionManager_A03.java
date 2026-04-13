import java.security.*;
import java.util.*;

public class java_28632_SessionManager_A03 {
    private Map<String, Boolean> sessionMap;
    private List<String> allowedSessions;

    public java_28632_SessionManager_A03() {
        sessionMap = new HashMap<>();
        allowedSessions = new ArrayList<>();

        // Add a list of allowed sessions here.
        allowedSessions.add("session1");
        allowedSessions.add("session2");
        allowedSessions.add("session3");
    }

    public boolean validateSession(String sessionId) {
        boolean isValid = false;

        // Use a message digest to check the session ID against a hash.
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theDigest = md.digest(sessionId.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < theDigest.length; i++) {
                sb.append(Integer.toString((theDigest[i] & 0xff) + 0x100, 16).substring(1));
            }

            isValid = allowedSessions.contains(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return isValid;
    }

    public static void main(String[] args) {
        SecureSessionManager ssm = new SecureSessionManager();

        // Generate a session ID.
        String sessionId = UUID.randomUUID().toString();

        // Validate the session ID.
        if (ssm.validateSession(sessionId)) {
            System.out.println("Session ID is valid.");

            // Store the session ID in a map.
            ssm.sessionMap.put(sessionId, true);
        } else {
            System.out.println("Session ID is invalid.");
        }
    }
}