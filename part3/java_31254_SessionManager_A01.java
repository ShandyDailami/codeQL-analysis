public class java_31254_SessionManager_A01 {
    // Assume a session is a user's login session
    private Session session;

    // Assume a user's login info is userName and password
    private String userName;
    private String password;

    public java_31254_SessionManager_A01(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void openSession() {
        // Assume a successful login means the user is authenticated
        if (isUserAuthenticated()) {
            session = new Session();
            session.setActive(true);
        } else {
            throw new SecurityException("Authentication failed for user " + userName);
        }
    }

    public void closeSession() {
        if (session != null && session.isActive()) {
            session.setActive(false);
        }
    }

    private boolean isUserAuthenticated() {
        // Assume a valid login means the userName and password match
        return userName.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("admin", "password");
        sessionManager.openSession();

        // Perform some operations

        sessionManager.closeSession();
    }
}