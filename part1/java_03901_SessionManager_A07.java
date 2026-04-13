public class java_03901_SessionManager_A07 {
    private static boolean isAuthenticated = false;

    public static void main(String[] args) {
        login("admin", "password"); // Login with valid credentials
        validateUser(); // Validate if user is authenticated
    }

    public static void login(String username, String password) {
        // Simulate login
        if (username.equals("admin") && password.equals("password")) {
            isAuthenticated = true;
            System.out.println("User is authenticated.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    public static void validateUser() {
        if (isAuthenticated) {
            System.out.println("User is authenticated.");
        } else {
            System.out.println("User is not authenticated.");
        }
    }
}