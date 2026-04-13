public class java_35225_SessionManager_A01 {
    private static SessionManager instance;
    private static User currentUser;

    private java_35225_SessionManager_A01() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void login(String username, String password) {
        // This is a placeholder for real login functionality.
        // In a real application, it would involve a call to a database
        // and we would need to compare the entered password with the hashed password
        // stored in the database.
        if (username.equals("admin") && password.equals("password")) {
            User user = new User();
            user.setUsername("admin");
            setCurrentUser(user);
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public void logout() {
        setCurrentUser(null);
    }

    public void secureOperation() {
        if (currentUser == null) {
            throw new RuntimeException("You must be logged in to perform this operation");
        } else if (!currentUser.getRole().equals("admin")) {
            throw new RuntimeException("You do not have permission to perform this operation");
        }
        // This is a placeholder for real security-sensitive operation.
        // In a real application, it would involve some sort of file I/O or network I/O.
        System.out.println("Secure operation performed by " + currentUser.getUsername());
    }
}