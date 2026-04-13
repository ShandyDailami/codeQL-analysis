public class java_09093_SessionManager_A07 {

    private HashMap<String, User> users;

    public java_09093_SessionManager_A07() {
        users = new HashMap<>();
    }

    public boolean isUserAuthenticated(String username) {
        // Implement authentication logic here.
        // This is a placeholder and won't work in a real-world scenario.
        return true;
    }

    public boolean isUserAuthorized(String username, String resource) {
        // Implement authorization logic here.
        // This is a placeholder and won't work in a real-world scenario.
        return true;
    }
}

public class SessionManager {

    private UserManager userManager;

    public java_09093_SessionManager_A07(UserManager userManager) {
        this.userManager = userManager;
    }

    public UserSession startSession(String username) {
        if (userManager.isUserAuthenticated(username) && userManager.isUserAuthorized(username, "resource")) {
            return new UserSession(username);
        } else {
            throw new AuthFailureException();
        }
    }
}

public class UserSession {

    private String username;

    public java_09093_SessionManager_A07(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}