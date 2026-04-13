import java.util.HashMap;
import java.util.UUID;
import java.util.Map;

public class java_20531_SessionManager_A07 {
    private Map<UUID, String> sessionMap;

    public java_20531_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String data) {
        UUID uniqueId = UUID.randomUUID();
        String hash = hashData(data);
        sessionMap.put(uniqueId, hash);
        return uniqueId.toString();
    }

    public boolean validateSession(String sessionId, String data) {
        UUID uuid = UUID.fromString(sessionId);
        String hash = sessionMap.get(uuid);
        return hash != null && hash.equals(hashData(data));
    }

    private String hashData(String data) {
        // A simple hash function, this is not a secure hashing function
        int hash = 7;
        for (char c : data.toCharArray()) {
            hash = 31 * hash + c;
        }
        return String.valueOf(hash);
    }
}