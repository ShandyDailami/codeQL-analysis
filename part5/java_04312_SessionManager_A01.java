public class java_04312_SessionManager_A01 {
    // Define a static list to simulate a database
    private static List<Session> sessions = new ArrayList<>();
    private static int sessionIdCounter = 0;

    // Session class
    public static class Session {
        public String id;
        public User user;

        public java_04312_SessionManager_A01(User user) {
            this.id = String.valueOf(sessionIdCounter++);
            this.user = user;
        }

        @Override
        public String toString() {
            return "Session id=" + id + " user=" + user;
        }
    }

    // User class
    public static class User {
        public String name;

        public java_04312_SessionManager_A01(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User name=" + name;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create users
        User user1 = new User("User1");
        User user2 = new User("User2");

        // Create sessions for users
        Session session1 = new Session(user1);
        Session session2 = new Session(user2);
        Session session3 = new Session(user1);

        // Print sessions
        System.out.println("Sessions: " + session1 + ", " + session2 + ", " + session3);

        // Close session
        closeSession(session2);

        // Print sessions again to show the session has been closed
        System.out.println("Sessions after closing session2: " + session1 + ", " + session2 + ", " + session3);
    }

    // Method to close a session
    public static void closeSession(Session session) {
        sessions.remove(session);
        System.out.println("Closed session: " + session);
    }
}