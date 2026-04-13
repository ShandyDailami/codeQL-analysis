import java.security.SecureRandom;

public class java_12362_SessionManager_A08 {
    private static final SecureRandom rand = new SecureRandom();
    private final int SECRET = 123456789; // secret key for integrity failure prevention

    // class to represent a user session
    public static class Session {
        private String id;
        private String userId;
        private long creationTime;

        public java_12362_SessionManager_A08(String id, String userId) {
            this.id = id;
            this.userId = userId;
            this.creationTime = System.currentTimeMillis();
        }

        public boolean isValid(int ttl) {
            long currentTime = System.currentTimeMillis();
            return currentTime - creationTime <= ttl;
        }
    }

    // class to represent a user account
    public static class User {
        private String id;
        private String password;

        public java_12362_SessionManager_A08(String id, String password) {
            this.id = id;
            this.password = password; // hashed password for security
        }

        public boolean isValidPassword(String password) {
            // compare hashed password with input password
            // for simplicity, we assume that the input password is already hashed
            return this.password.equals(password);
        }
    }

    private User currentUser;
    private final Session session;

    public java_12362_SessionManager_A08(String userId) {
        session = new Session(generateSessionId(), userId);
    }

    private String generateSessionId() {
        return String.valueOf(rand.nextLong());
    }

    public boolean login(String id, String password) {
        if (currentUser != null) {
            return false;
        }

        // assuming userRepository is a class that fetches User from a database
        User user = userRepository.findUserById(id);
        if (user == null || !user.isValidPassword(password)) {
            return false;
        }

        currentUser = user;
        return true;
    }

    public boolean isSessionValid(int ttl) {
        if (currentUser == null) {
            return false;
        }

        // for simplicity, we assume that the ttl is in milliseconds
        return session.isValid(ttl);
    }
}