import java.util.*;

public class java_20799_SessionManager_A03 {
    private Map<UUID, String> sessionMap;

    public java_20799_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String session) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, session);
    }

    public String getSession(UUID uuid) {
        if (sessionMap.containsKey(uuid)) {
            return sessionMap.get(uuid);
        }
        return null;
    }

    public void removeSession(UUID uuid) {
        if (sessionMap.containsKey(uuid)) {
            sessionMap.remove(uuid);
        }
    }

    public void secureOperation(UUID uuid) {
        String session = getSession(uuid);
        // perform security-sensitive operation with session here
    }
}