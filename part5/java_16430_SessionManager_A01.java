// Start of code

public class java_16430_SessionManager_A01 {
    private boolean isLoggedIn;

    public java_16430_SessionManager_A01() {
        isLoggedIn = false;
    }

    public void login(String username, String password) {
        // Simulate login process
        if(username.equals("admin") && password.equals("password")) {
            isLoggedIn = true;
            System.out.println("User is logged in.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void logout() {
        if(isLoggedIn) {
            isLoggedIn = false;
            System.out.println("User is logged out.");
        } else {
            System.out.println("No user to log out.");
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}

public class SessionManager {
    private UserSession userSession;

    public java_16430_SessionManager_A01(UserSession userSession) {
        this.userSession = userSession;
    }

    public void performOperation(String operation) {
        if(userSession.isLoggedIn()) {
            // Simulate performing an operation
            System.out.println("Performing operation: " + operation);
        } else {
            System.out.println("User is not logged in. Cannot perform operation.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        UserSession userSession = new UserSession();
        SessionManager sessionManager = new SessionManager(userSession);

        // Simulate login
        userSession.login("admin", "password");

        // Use session manager
        sessionManager.performOperation("Read data");
        sessionManager.performOperation("Update data");

        // Simulate logout
        userSession.logout();
    }
}

// End of code