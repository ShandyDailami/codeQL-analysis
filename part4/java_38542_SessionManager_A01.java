import java.util.ArrayList;
import java.util.List;

public class java_38542_SessionManager_A01 {
    private List<Session> sessions;
    private int sessionCount;

    public java_38542_SessionManager_A01(int size) {
        sessions = new ArrayList<>(size);
        sessionCount = 0;
        for (int i = 0; i < size; i++) {
            sessions.add(new Session(i));
        }
    }

    public Session getSession() {
        if (sessionCount < sessions.size()) {
            return sessions.get(sessionCount++);
        } else {
            throw new RuntimeException("No more sessions available");
        }
    }

    public void setSessionName(Session session, String name) {
        // Assuming setSessionName is a method to set the name of a session
        session.setName(name);
    }
}

class Session {
    private int id;
    private String name;

    public java_38542_SessionManager_A01(int id) {
        this.id = id;
        this.name = "Session " + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}