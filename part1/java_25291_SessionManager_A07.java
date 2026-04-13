public class java_25291_SessionManager_A07 {
    private User currentUser;

    public boolean login(String username, String password) {
        // simulate a login by comparing the provided username and password to a fixed set of values
        if (username.equals("admin") && password.equals("password")) {
            currentUser = new User(username, true);
            return true;
        }
        return false;
    }

    public void logout() {
        if (currentUser != null) {
            currentUser.setLoggedIn(false);
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        if (manager.login("admin", "password")) {
            System.out.println("Logged in as admin.");
        } else {
            System.out.println("Failed to log in.");
        }
        manager.logout();
        System.out.println("Logged out.");
    }
}

class User {
    private String username;
    private boolean loggedIn;

    public java_25291_SessionManager_A07(String username, boolean loggedIn) {
        this.username = username;
        this.loggedIn = loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}