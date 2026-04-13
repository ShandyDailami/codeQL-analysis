public class java_36867_SessionManager_A01 {
    private static SessionManager instance;
    private static User currentUser;

    private java_36867_SessionManager_A01() {
        // prevent instantiation
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession(String userName) {
        currentUser = new User(userName);
    }

    public void endSession() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private static class User {
        private String name;

        public java_36867_SessionManager_A01(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}