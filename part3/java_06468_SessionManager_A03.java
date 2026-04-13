import java.util.HashMap;
import java.util.Map;

public class java_06468_SessionManager_A03 {

    private static Map<String, Session> sessionMap = new HashMap<>();

    public static Session getSession(String dbName) {
        Session session = sessionMap.get(dbName);
        if (session == null) {
            session = createSession(dbName);
            sessionMap.put(dbName, session);
        }
        return session;
    }

    private static Session createSession(String dbName) {
        // This is a simple placeholder implementation, in a real-world application you would connect to the database here.
        Session session = new Session(dbName);
        // TODO: add some database operations here to initialize the session.
        return session;
    }

    private static class Session {
        private String dbName;

        Session(String dbName) {
            this.dbName = dbName;
        }

        public String getDbName() {
            return dbName;
        }
    }
}