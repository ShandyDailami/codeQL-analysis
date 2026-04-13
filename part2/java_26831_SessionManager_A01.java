public class java_26831_SessionManager_A01 {
    private User currentUser;

    public void login(String username, String password) {
        // Simulating a login operation that might be performed in a secure environment.
        // This is a place-holder, real-world implementation would require actual authentication.
        if (authenticate(username, password)) {
            currentUser = new User(username);
            System.out.println("User logged in successfully!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    public void logout() {
        // Simulating a logout operation. In a secure environment, this would be a way to end the session and release resources.
        if (currentUser != null) {
            System.out.println("User " + currentUser.getUsername() + " logged out successfully!");
            currentUser = null;
        }
    }

    public void performOperation(String operation) {
        if (currentUser != null) {
            if ("write".equals(operation) && !currentUser.isAdmin()) {
                System.out.println("You do not have permission to perform this operation.");
                return;
            }
            if ("read".equals(operation) && currentUser.isAdmin()) {
                System.out.println("Reading operation permitted!");
                return;
            }
        }
        System.out.println("You must log in to perform this operation.");
    }

    private boolean authenticate(String username, String password) {
        // Simulating an authentication operation. In a real-world scenario, this would require a secure authentication mechanism.
        // This is a placeholder, real-world implementation would require actual authentication.
        return "admin".equals(username) && "password".equals(password);
    }
}

class User {
    private String username;
    private boolean isAdmin;

    public java_26831_SessionManager_A01(String username) {
        this.username = username;
        this.isAdmin = "admin".equals(username);
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}