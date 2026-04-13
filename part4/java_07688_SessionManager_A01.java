public class java_07688_SessionManager_A01 {

    // This is a flag that represents if the user has a valid session or not
    private boolean isSessionActive;

    // This is the user that is currently logged in
    private User loggedUser;

    // Constructor
    public java_07688_SessionManager_A01() {
        isSessionActive = false;
        loggedUser = null;
    }

    // Method that tries to log the user in
    public boolean login(String username, String password) {
        // This is a placeholder for the actual implementation of login
        // In the real world, you would have to call a secure server to verify the username and password
        // If they are valid, return true and set the loggedUser and isSessionActive
        // If they are not valid, return false and reset the loggedUser and isSessionActive

        if (username.equals("admin") && password.equals("password")) {
            loggedUser = new User(username, password);
            isSessionActive = true;
            return true;
        } else {
            loggedUser = null;
            isSessionActive = false;
            return false;
        }
    }

    // Method that checks if the user has a valid session
    public boolean hasValidSession() {
        return isSessionActive;
    }

    // Method that returns the currently logged user
    public User getLoggedUser() {
        return loggedUser;
    }
}