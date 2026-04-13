import java.util.HashMap;
import java.util.Map;

public class java_14049_SessionManager_A03 {
    private Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String id) {
        Session session = sessions.get(id);
        if (session == null) {
            session = new Session(id);
            sessions.put(id, session);
        }
        return session;
    }

    public void closeSession(String id) {
        Session session = sessions.get(id);
        if (session != null) {
            sessions.remove(id);
       
            // For real-world application, you'd want to handle the closing of session here
            // which is typically done within a try-with-resources statement
            // or using a session factory to close the session
            // Note: This is a simplified example
            session.close();
        }
    }
}

class Session {
    private String id;

    public java_14049_SessionManager_A03(String id) {
        this.id = id;
    }

    // Simplified for demonstration purposes
    public void close() {
        System.out.println("Closing session with id: " + id);
    }
}