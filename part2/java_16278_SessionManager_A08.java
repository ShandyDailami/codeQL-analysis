public class java_16278_SessionManager_A08 {
    private String id;
    private String data;

    public java_16278_SessionManager_A08(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }
}

public class SecureSessionManager {
    private static Map<String, Session> sessions = new HashMap<>();

    public static Session createSession(String id, String data) {
        Session session = new Session(id, data);
        sessions.put(id, session);
        return session;
    }

    public static Session getSession(String id) {
        Session session = sessions.get(id);
        if (session == null) {
            throw new SecurityException("Invalid session id");
        }
        return session;
    }

    public static void updateSession(String id, String newData) {
        Session session = getSession(id);
        session.setData(newData);
    }

    public static void deleteSession(String id) {
        sessions.remove(id);
    }
}