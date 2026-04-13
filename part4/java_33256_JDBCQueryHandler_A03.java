import java.sql.*;

public class java_33256_JDBCQueryHandler_A03 {

    // Establish a connection to the database
    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
        return conn;
    }

    // Execute a SELECT query
    public ResultSet executeSelectQuery(String query) {
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return rs;
    }

    // Execute a INSERT, UPDATE, DELETE query
    public int executeUpdateQuery(String query) {
        Connection conn = getConnection();
        int rowsUpdated = 0;
        try {
            Statement stmt = conn.createStatement();
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return rowsUpdated;
    }

    // Main method to test above functionality
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Perform SELECT query
        ResultSet rs = handler.executeSelectQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        // Perform INSERT query
        int rowsInserted = handler.executeUpdateQuery("INSERT INTO users (name, email) VALUES ('Test', 'test@test.com')");
        System.out.println("Rows inserted: " + rowsInserted);
    }
}