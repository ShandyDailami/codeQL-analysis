import java.util.HashMap;
import java.util.Map;

// A simple in-memory session storage
public class java_15689_SessionManager_A08 {
    private Map<String, String> storage = new HashMap<>();

    public void save(String sessionId, String value) {
        storage.put(sessionId, value);
    }

    public String get(String sessionId) {
        return storage.get(sessionId);
    }

    public void delete(String sessionId) {
        storage.remove(sessionId);
    }
}

// A simple session manager
public class SessionManager {
    private InMemorySessionStorage storage;

    public java_15689_SessionManager_A08(InMemorySessionStorage storage) {
        this.storage = storage;
    }

    public void saveSession(String sessionId, String value) {
        storage.save(sessionId, value);
    }

    public String getSession(String sessionId) {
        return storage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        storage.delete(sessionId);
    }
}

// The main program
public class Main {
    public static void main(String[] args) {
        InMemorySessionStorage storage = new InMemorySessionStorage();
        SessionManager sessionManager = new SessionManager(storage);

        sessionManager.saveSession("session1", "value1");
        String value1 = sessionManager.getSession("session1");

        sessionManager.saveSession("session2", "value2");
        String value2 = sessionManager.getSession("session2");

        sessionManager.deleteSession("session1");
        String value3 = sessionManager.getSession("session1");

        System.out.println("Value1: " + value1);
        System.out.println("Value2: " + value2);
        System.out.println("Value3: " + value3);
    }
}