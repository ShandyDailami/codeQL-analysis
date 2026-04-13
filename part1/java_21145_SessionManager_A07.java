public class java_21145_SessionManager_A07 {
    private static User currentUser;

    public static void main(String[] args) {
        if (isUserAuthenticated("admin")) {
            SessionManager.login("admin");
            System.out.println("Welcome back, admin!");
            System.out.println("Accessing sensitive content...");
        } else {
            System.out.println("Access denied.");
        }
    }

    public static boolean isUserAuthenticated(String userName) {
        // Implementation of user authentication system here
        // In a real-world application, this would involve talking to a database or other persistent storage system
        // Here we'll just simulate a successful authentication
        currentUser = new User(userName, true);
        return true;
    }

    public static void login(String userName) {
        // Implementation of login system here
        // In a real-world application, this would involve sending a request to a server and receiving a response
        // Here we'll just set the currentUser variable
        currentUser = new User(userName, true);
    }

    public static void logout() {
        // Implementation of logout system here
        // In a real-world application, this would involve sending a request to a server and receiving a response
        // Here we'll just set the currentUser variable to null
        currentUser = null;
    }
}

class User {
    private String userName;
    private boolean isAuthenticated;

    public java_21145_SessionManager_A07(String userName, boolean isAuthenticated) {
        this.userName = userName;
        this.isAuthenticated = isAuthenticated;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}