import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class java_23128_SessionManager_A01 {

    private Map<String, Object> sessionData;
    private Set<String> sessionIds;

    public java_23128_SessionManager_A01() {
        this.sessionData = new HashMap<>();
        this.sessionIds = new HashMap<>();
    }

    public String createSession(Object data) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        this.sessionIds.put(sessionId, null);
        this.sessionData.put(sessionId, data);
        return sessionId;
    }

    public Object getSessionData(String sessionId) {
        return this.sessionData.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (this.sessionIds.containsKey(sessionId)) {
            this.sessionIds.remove(sessionId);
            this.sessionData.remove(sessionId);
        }
    }

    public void destroySession(String sessionId) {
        deleteSession(sessionId);
    }
}