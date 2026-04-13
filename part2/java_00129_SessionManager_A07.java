import java.security.SecureRandom;
import java.util.Base64;

public class java_00129_SessionManager_A07 {
    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder();
    private static final Base64.Decoder decoder = Base64.getUrlDecoder();
    private static final int MAX_CREDENTIALS = 10;
    private static int credentialsCount = 0;
    private static Session[] sessions = new Session[MAX_CREDENTIALS];

    public static class Session {
        private String id;
        private User user;

        public java_00129_SessionManager_A07(User user) {
            this.id = createSessionId();
            this.user = user;
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        private String createSessionId() {
            byte[] randomBytes = new byte[16];
            random.nextBytes(randomBytes);
            return encoder.encodeToString(randomBytes);
        }
    }

    public static class User {
        private String name;
        private String password;

        public java_00129_SessionManager_A07(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }

    public static User login(String name, String password) {
        // Simulate security failure
        if (credentialsCount >= MAX_CREDENTIALS) {
            return null;
        }

        credentialsCount++;

        // Assume password is correct for the user
        return new User(name, password);
    }

    public static Session createSession(User user) {
        for (Session session : sessions) {
            if (session != null && session.getUser().getName().equals(user.getName())) {
                return session;
            }
        }

        Session newSession = new Session(user);
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] == null) {
                sessions[i] = newSession;
                break;
            }
        }

        return newSession;
    }
}