import java.util.HashMap;
import java.util.Map;

public class java_08778_SessionManager_A03 {
    private Map<String, Session> sessions = new HashMap<>();

    public Session openSession(String userName) {
        Session session = sessions.get(userName);

        if (session == null) {
            session = new Session(userName);
            sessions.put(userName, session);
        }

        return session;
    }
}

public class Session {
    private String userName;

    public java_08778_SessionManager_A03(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

public class SessionFactoryImpl extends SessionFactory {
    private boolean isDirty = false;

    public SessionImpl openSession() {
        SessionImpl session = (SessionImpl) super.openSession("user");
        session.setUserName("newUser");
        isDirty = true;
        return session;
    }

    public void update() {
        if (isDirty) {
            System.out.println("Updating session...");
            isDirty = false;
        }
    }
}

public class SessionImpl extends Session {
    private boolean isDirty = false;

    public java_08778_SessionManager_A03(String userName) {
        super(userName);
    }

    public void setUserName(String userName) {
        isDirty = true;
        super.setUserName(userName);
    }

    public void update() {
        if (isDirty) {
            System.out.println("Updating session...");
            isDirty = false;
        }
    }
}