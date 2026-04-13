public class java_21171_SessionManager_A07 {
    // Assume we have a User class to store user information
    private User currentUser;

    public void login(String username, String password) {
        // Here we'd typically check the database for a user with these credentials
        // For the sake of this example, let's assume a successful login

        // Simulating a failed login
        if (username.equals("admin") && password.equals("password")) {
            currentUser = new User("Admin", "User");
            System.out.println("Successfully logged in as " + currentUser.getName());
        } else {
            System.out.println("Invalid username or password");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

public class User {
    private String name;
    private String role;

    public java_21171_SessionManager_A07(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}