import java.util.*;

public class java_03182_SessionManager_A07 {
    // This is a simple implementation of a SessionManager. It only stores sessions in memory.
    // In a real-world application, you would likely use a database or a more complex data structure.

    private static class Session {
        private String user;

        public java_03182_SessionManager_A07(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }

    private List<Session> sessions = new ArrayList<>();

    public void startSession(String user) {
        // Simulate an auth failure by not checking the user's password
        // This could be replaced with a more complex process to check the user's password
        if (user.equals("failure")) {
            throw new RuntimeException("Authentication failed");
        }

        Session session = new Session(user);
        sessions.add(session);
    }

    public void endSession(String user) {
        // Simulate the end of a session by finding the session for the user
        Optional<Session> session = sessions.stream().filter(s -> s.getUser().equals(user)).findFirst();

        if (session.isPresent()) {
            sessions.remove(session.get());
        }
    }
}