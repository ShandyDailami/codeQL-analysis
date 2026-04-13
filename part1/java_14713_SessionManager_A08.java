import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

public class java_14713_SessionManager_A08 {
    private Map<String, String> store;

    public java_14713_SessionManager_A08() {
        store = new HashMap<String, String>();
    }

    public String createSession(String sessionId) {
        store.put(sessionId, "created");
        return sessionId;
    }

    public String getSession(String sessionId) {
        return store.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        store.remove(sessionId);
    }

    public void invalidateAllSessions() {
        Collection<String> keys = store.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            store.remove(key);
        }
    }
}