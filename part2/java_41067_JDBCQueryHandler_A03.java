import java.sql.*;

public class java_41067_JDBCQueryHandler_A03 {
    // Define a static username and password variables
    private static String username = "user";
    private static String password = "password";

    public static void main(String[] args) {
        try {
            // Get a connection to the database
            Connection conn = getConnection();

            // Execute a query
            executeQuery(conn, "SELECT * FROM Users WHERE username = ? AND password = ?");

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        // Create a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String driver = "com.mysql.jdbc.Driver";
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }

    private static void executeQuery(Connection conn, String query) throws SQLException {
        // Prepare a statement for execution
        PreparedStatement pstmt = conn.prepareStatement(query);

        // Bind parameters to the statement
        pstmt.setString(1, "user1");
        pstmt.setString(2, "password1");

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        // Process the result set
        while (rs.next()) {
            System.out.println("User: " + rs.getString("username"));
        }
    }
}