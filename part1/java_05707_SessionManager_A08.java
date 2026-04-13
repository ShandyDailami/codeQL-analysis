public class java_05707_SessionManager_A08 {

    // Step 1: Declare a static Session variable.
    private static Session session;

    // Step 2: Create a static method for opening a session.
    public static void openSession() {
        try {
            // Load the library.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish a connection.
            session = SessionBuilder.getSessionBuilder().build(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Step 4: Create a method for closing the session.
    public static void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    // Step 5: Create a method to perform a security-sensitive operation.
    public static void performSecurityOperation(String operation) {
        if (session != null) {
            // Step 6: Use session for the security-sensitive operation.
            session.createQuery(operation).executeUpdate();
        } else {
            System.out.println("Session is null, cannot perform operation.");
        }
    }

    public static void main(String[] args) {
        // Open session.
        openSession();

        // Perform a security-sensitive operation.
        performSecurityOperation("SELECT * FROM Users WHERE username='admin'");

        // Close session.
        closeSession();
    }
}