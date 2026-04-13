import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class java_24328_SessionManager_A03 {
    private ConcurrentHashMap<String, Session> sessions;
    private ConcurrentSkipListMap<Long, Session> sessionsByCreationTime;
    private long nextSessionId;

    public java_24328_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
        sessionsByCreationTime = new ConcurrentSkipListMap<>();
        nextSessionId = 0;
    }

    public Session createSession() {
        Session session = new Session(nextSessionId++, System.currentTimeMillis());
        sessions.put(session.getId(), session);
        sessionsByCreationTime.put(session.getCreationTime(), session);
        return session;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void closeSession(String id) {
        Session session = sessions.get(id);
        if (session != null) {
            sessions.remove(id);
            sessionsByCreationTime.get(session.getCreationTime()).remove(session);
        }
    }
}

class Session {
    private String id;
    private long creationTime;

    public java_24328_SessionManager_A03(String id, long creationTime) {
        this.id = id;
        this.creationTime = creationTime;
    }

    public String getId() {
        return id;
    }

    public long getCreationTime() {
        return creationTime;
    }
}