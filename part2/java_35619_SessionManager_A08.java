public class java_35619_SessionManager_A08 {
    private static int userId;

    public static void setUserId(int userId) {
        if (userId < 0) {
            throw new IllegalArgumentException("User ID must be a non-negative integer.");
        }
        SessionManager.userId = userId;
    }

    public static int getUserId() {
        return userId;
    }

    public static void main(String[] args) {
        setUserId(12345);
        System.out.println("User ID: " + getUserId());

        // Modify the user ID
        setUserId(67890);
        System.out.println("Modified User ID: " + getUserId());
    }
}