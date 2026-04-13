import java.sql.SQLException;

public class java_34270_SessionManager_A07 {

    // In-memory database for simplicity
    private static String[] database = new String[]{"user1", "user2", "user3"};

    // Simplified database operations
    private static boolean checkDatabase(String username, String password) {
        // This is a very basic check, you should replace this with a secure one
        return username.equals(password);
    }

    // Simple session handling
    public static void startSession(String username, String password) {
        try {
            if (checkDatabase(username, password)) {
                System.out.println("Session started for user: " + username);
            } else {
                throw new SQLException("Authentication failed");
            }
        } catch (SQLException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    public static void endSession(String username) {
        System.out.println("Session ended for user: " + username);
    }

    public static void main(String[] args) {
        // Simulate login attempts
        try {
            startSession("user1", "password");
            startSession("user1", "wrong_password");
            endSession("user1");
            startSession("wrong_user", "password");
        } catch (SQLException e) {
            System.out.println("Failed to start session: " + e.getMessage());
        }
    }
}