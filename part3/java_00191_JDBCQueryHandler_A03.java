import java.sql.*;

public class java_00191_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Connection and statement
    private Connection conn = null;
    private Statement stmt = null;

    // Open a connection
    public void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    // Close the connection
    public void disconnect() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    // Execute a query
    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return null;
    }

    // Execute a non-returning query
    public void executeNonReturningQuery(String query) {
        try {
            stmt.execute(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    // Insert a new user into the database
    public void insertUser(String name, String email) {
        String query = "INSERT INTO USERS (NAME, EMAIL) VALUES ('" + name + "', '" + email + "')";
        executeNonReturningQuery(query);
    }

    // Main method to test the code
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect();
        handler.insertUser("John", "john@example.com");
        handler.disconnect();
    }
}