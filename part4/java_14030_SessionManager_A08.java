import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_14030_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_14030_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) throws NoSuchAlgorithmException {
        // Generate a random session id
        String sessionId = generateRandomSessionId();

        // Hash the user id with a message digest algorithm
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(userId.getBytes());

        // Convert the hash to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        // Store the session id and its hash in the map
        sessionMap.put(sessionId, hexString.toString());

        return sessionId;
    }

    public boolean validateSession(String sessionId, String expectedHash) throws NoSuchAlgorithmException {
        // If the session id is not in the map, return false
        if (!sessionMap.containsKey(sessionId)) {
            return false;
        }

        // Retrieve the hash for the session id from the map
        String actualHash = sessionMap.get(sessionId);

        // Compare the hashes
        return actualHash.equals(expectedHash);
    }

    private String generateRandomSessionId() {
        // Generate a random session id
        return String.valueOf(System.nanoTime());
    }
}