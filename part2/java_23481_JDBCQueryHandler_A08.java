import java.sql.*;

public class java_23481_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Get a connection
            Connection conn = getConnection();

            // Step 2: Prepare and execute the query
            executeQuery(conn);

            // Step 3: Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private static void executeQuery(Connection conn) throws SQLException {
        // This is a security-sensitive operation related to A08_IntegrityFailure
        // Here I'm using a prepared statement to prevent SQL injection
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1); // for example
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}