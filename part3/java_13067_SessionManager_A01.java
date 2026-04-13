public class java_13067_SessionManager_A01 {
    private String id;
    private User user;

    public java_13067_SessionManager_A01(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}

public class User {
    private String name;

    public java_13067_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class SessionManager {
    private Session[] sessions;

    public java_13067_SessionManager_A01() {
        sessions = new Session[10];
        for (int i = 0; i < sessions.length; i++) {
            sessions[i] = null;
        }
    }

    public void addSession(Session session) {
        // Add session to sessions array.
        // This is a simplistic implementation and a real-world use case would require a
        // more sophisticated mechanism for managing sessions.
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] == null) {
                sessions[i] = session;
                break;
            }
        }
    }

    public Session getSession(String id) {
        // Retrieve session from sessions array.
        // Again, a real-world use case would require a more sophisticated mechanism for
        // managing sessions.
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] != null && sessions[i].getId().equals(id)) {
                return sessions[i];
            }
        }

        return null;
    }
}