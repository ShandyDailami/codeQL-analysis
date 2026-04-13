import java.util.HashMap;
import java.util.Map;

public class java_16504_SessionManager_A01 implements SessionManagerInterface {
    private Map<String, Session> sessionMap;
    private Map<String, User> userMap;

    public java_16504_SessionManager_A01() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    @Override
    public Session getSession(String userId) {
        User user = userMap.get(userId);
        if (user == null) {
            throw new UserNotExistsException("User does not exist");
        }
        Session session = user.getSession();
        if (session == null) {
            session = new Session();
            user.setSession(session);
            sessionMap.put(session.getId(), session);
        }
        return session;
    }

    @Override
    public void setSession(Session session, User user) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        user.setSession(session);
        sessionMap.put(session.getId(), session);
        userMap.put(user.getId(), user);
    }

    @Override
    public void closeSession(Session session, User user) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        Session existingSession = user.getSession();
        if (existingSession == null) {
            throw new IllegalStateException("User does not have a session open");
        }
        if (!existingSession.getId().equals(session.getId())) {
            throw new IllegalStateException("Session IDs do not match");
        }
        user.setSession(null);
        sessionMap.remove(session.getId());
    }
}