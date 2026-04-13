public class java_29507_SessionManager_A01 {
    private Session[] sessions;
    private int size;

    public java_29507_SessionManager_A01(int size) {
        sessions = new Session[size];
        this.size = size;
    }

    public void setSession(int index, Session session) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds. Size: " + size);
        }
        sessions[index] = session;
    }

    public Session getSession(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds. Size: " + size);
        }
        return sessions[index];
    }
}

public class Session {
    private String id;
    private User user;

    public java_29507_SessionManager_A01(String id, User user) {
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

    public java_29507_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}