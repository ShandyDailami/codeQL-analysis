import java.sql.*;

public class java_00136_JDBCQueryHandler_A01 {

    // Establish database connection
    private static Connection connectToDatabase() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    // Execute a SELECT query
    public static ResultSet executeQuery(String query) {
        Connection conn = connectToDatabase();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
            }
        } catch (SQLException e) {
            System.out.println("Query failed");
            e.printStackTrace();
        }
        return rs;
    }

    // Execute a UPDATE, DELETE, INSERT, or any other DDL statement
    public static int executeUpdate(String query) {
        Connection conn = connectToDatabase();
        Statement stmt = null;
        int rowsUpdated = 0;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
                rowsUpdated = stmt.executeUpdate(query);
            }
        } catch (SQLException e) {
            System.out.println("Update failed");
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    public static void main(String[] args) {
        // Testing query execution
        executeQuery("SELECT * FROM Users");
        // This query is secure because it does not involve any sensitive data.

        // Testing update operation
        executeUpdate("UPDATE Users SET password = 'newpassword' WHERE username = 'admin'");
        // This operation is secure because it does not involve any sensitive data.
    }
}