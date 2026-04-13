import java.sql.*;

public class java_18321_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Get a connection
            Connection conn = getConnection();

            // Step 2: Use connection for querying
            executeQuery(conn);

            // Step 3: Close connection
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection conn) throws SQLException {
        String query = "SELECT * FROM users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password"); // BREAKING ACCESS CONTROL
            System.out.println("Username: " + username);
        }
        rs.close();
        stmt.close();
    }
}