public class java_19691_SessionManager_A07 {

    private static boolean isLoggedIn;

    public static void main(String[] args) {
        // Initialize session manager
        isLoggedIn = false;

        // Test session manager
        testSessionManager();

        // Log in a user
        login();

        // Test session manager again
        testSessionManager();

        // Log out a user
        logout();

        // Test session manager again
        testSessionManager();
    }

    private static void login() {
        if (isLoggedIn) {
            System.out.println("User already logged in");
        } else {
            isLoggedIn = true;
            System.out.println("User logged in");
        }
    }

    private static void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println("User logged out");
        } else {
            System.out.println("No user to log out");
        }
    }

    private static void testSessionManager() {
        if (isLoggedIn) {
            System.out.println("User is logged in");
        } else {
            System.out.println("No user is logged in");
        }
    }
}