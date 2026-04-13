import java.sql.*;

public class java_06365_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    public static void main(String[] args) {
        // Create a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Start a new transaction
            conn.setAutoCommit(false);

            // Query to check if the username and password exist in the database
            String query = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(query);

            // If there is a result, then the user exists and is authenticated
            if (rs.next()) {
                System.out.println("User is authenticated");
                // Authentication successful. Proceed with other operations...
            } else {
                System.out.println("Invalid credentials");
                // Authentication failed. Close the connection and end the program...
                conn.close();
                System.exit(0);
            }

            // Commit the transaction
            conn.commit();

            // Close the connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}