import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_42161_JDBCQueryHandler_A03 {

    // Step 1: Define the JDBC driver URL.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Step 2: Define the database credentials.
    private static final String USER = "root";
    private static final String PASS = "password";

    // Step 3: Establish a connection to the database.
    private Connection conn = null;

    // Step 4: The constructor will connect to the database.
    public java_42161_JDBCQueryHandler_A03() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 5: The method for executing a query.
    public void executeQuery(String query) {
        try {
            // Step 6: Prevent SQL Injection
            // We can't directly use the user-provided query in a SQL statement because it could potentially execute harmful SQL.
            // Instead, we'll use a parameterized query.
            // Step 7: Use the PreparedStatement to prevent SQL Injection
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 8: The method for closing the connection.
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        // Example of a query that could be potentially harmful.
        String harmfulQuery = "INSERT INTO Users (username, password) VALUES (?, ?)";
        jdbcQueryHandler.executeQuery(harmfulQuery);

        jdbcQueryHandler.closeConnection();
    }
}