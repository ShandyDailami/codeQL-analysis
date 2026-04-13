public class java_18691_SessionManager_A08 {

    private boolean isAuthenticated = false;

    public void login(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            isAuthenticated = true;
        } else {
            throw new SecurityException("Invalid username or password");
        }
    }

    public void logout() {
        isAuthenticated = false;
    }

    public void performAction(Runnable action) {
        if (!isAuthenticated) {
            throw new SecurityException("You must be logged in to perform this action");
        }

        action.run();
    }
}