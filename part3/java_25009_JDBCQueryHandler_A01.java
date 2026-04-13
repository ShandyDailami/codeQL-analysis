import java.sql.*;

public class java_25009_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_25009_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        conn.close();
    }
}

public class BrokenAccessControlExample {
    public static void main(String[] args) {
        try {
            // Replace with your database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "username";
            String password = "password";

            // Create a JDBCQueryHandler
            JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, username, password);

            // Execute a query to get all data from a table
            String query = "SELECT * FROM data";
            ResultSet resultSet = queryHandler.executeQuery(query);

            // Print the result
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getString("column1") + ", " + resultSet.getString("column2"));
            }

            // Close the query handler
            queryHandler.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}