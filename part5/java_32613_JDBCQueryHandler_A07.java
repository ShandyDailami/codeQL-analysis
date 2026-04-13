import java.sql.*;

public class java_32613_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Open a connection
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Execute a query
    public ResultSet executeQuery(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    // Main method for testing
    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();

        try {
            Connection conn = jdbcHandler.openConnection();
            ResultSet rs = jdbcHandler.executeQuery(conn, "SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }

            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}