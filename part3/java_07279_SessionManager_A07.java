public class java_07279_SessionManager_A07 {
    private User currentUser;

    public void startSession(String username, String password) {
        // This is where you'd typically hash and salt the password before storing it.
        // For simplicity, we'll just store the password as plain text.
        if (isValidCredentials(username, password)) {
            currentUser = new User(username, password);
            System.out.println("Session started for user: " + currentUser.getUsername());
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public void endSession() {
        if (currentUser != null) {
            currentUser = null;
            System.out.println("Session ended for user: " + currentUser.getUsername());
        } else {
            System.out.println("No user is currently logged in");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // This is where you'd typically check if the provided username and password match
        // against a stored hash and salt in the database. For simplicity, we'll just return true.
        return true; // This would typically be a call to a database to check the credentials.
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

public class User {
    private String username;
    private String password;

    public java_07279_SessionManager_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}