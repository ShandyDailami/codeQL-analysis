import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.collection.HashedMap;

public class java_07126_SessionManager_A03 {
    private Factory<String, Session> sessionFactory;
    private Factory<String, User> userFactory;

    public java_07126_SessionManager_A03() {
        sessionFactory = new HashedMap<String, Session>();
        userFactory = new HashedMap<String, User>();
    }

    public Session getSession(String username) {
        User user = userFactory.get(username);
        if (user == null) {
            // Create a new user and add to the factory.
            user = new User(username);
            userFactory.put(username, user);
        }

        String sessionId = sessionFactory.getKey(user);
        if (sessionId == null) {
            // Create a new session for the user and add to the factory.
            Session session = new Session(user);
            sessionFactory.put(user, session);
            return session;
        } else {
            // Return existing session for the user.
            return sessionFactory.get(sessionId);
        }
    }
}