import java.util.ArrayList;
import java.util.List;

public class java_01041_SessionManager_A01 {
    private static List<Session> sessions = new ArrayList<>();
    private static int sessionIdCounter = 1;

    public static class Session {
        private String id;
        private User user;

        public java_01041_SessionManager_A01(User user) {
            this.id = "SESSION_" + sessionIdCounter++;
            this.user = user;
            sessions.add(this);
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }
    }

    public static class User {
        private String name;
        private String password;

        public java_01041_SessionManager_A01(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public boolean isPasswordCorrect(String password) {
            return this.password.equals(password);
        }
    }

    public static Session createSession(User user) {
        return new Session(user);
    }

    public static void main(String[] args) {
        User user = new User("alice", "password");
        Session session = createSession(user);
        System.out.println("Session ID: " + session.getId());

        // This should fail because Alice does not have the correct password.
        boolean isPasswordCorrect = session.getUser().isPasswordCorrect("wrongPassword");
        System.out.println("Is password correct? " + isPasswordCorrect);

        // This should fail because Alice is trying to access a session they do not have access to.
        isPasswordCorrect = session.getUser().isPasswordCorrect(session.getUser().getPassword());
        System.out.println("Is password correct? " + isPasswordCorrect);
    }
}