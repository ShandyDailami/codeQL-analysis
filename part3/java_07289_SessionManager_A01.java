public class java_07289_SessionManager_A01 {

    private static SessionManager sessionManager;
    private static User currentUser;

    // Private constructor to prevent instantiation from outside
    private java_07289_SessionManager_A01() {}

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public void openSession(User user) throws UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException("User is not logged in.");
        }
        // open session logic
    }

    public void closeSession() {
        // close session logic
    }
}

class UserNotLoggedInException extends Exception {
    public java_07289_SessionManager_A01(String message) {
        super(message);
    }
}