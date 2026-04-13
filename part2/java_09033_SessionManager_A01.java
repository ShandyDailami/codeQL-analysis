import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class java_09033_SessionManager_A01 {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final Map<String, WeakReference<User>> sessionToUserMap;

    public java_09033_SessionManager_A01(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.sessionToUserMap = new HashMap<>();
    }

    public User getUser(String sessionId) {
        if (sessionRepository.contains(sessionId)) {
            WeakReference<User> weakReference = sessionToUserMap.get(sessionId);
            User user = weakReference.get();
            if (user != null) {
                return user;
            }
        }
        return null;
    }

    public void createSession(String userId, User user) {
        if (userRepository.contains(userId)) {
            userRepository.find(userId).ifPresent(user1 -> {
                Session session = new Session(user1);
                sessionRepository.add(session);
                sessionToUserMap.put(session.getId(), new WeakReference<>(user1));
            });
        }
    }
}