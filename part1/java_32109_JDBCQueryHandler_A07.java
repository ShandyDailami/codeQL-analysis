import java.sql.*;

public class java_32109_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Open a connection to the database
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Execute a query and return a ResultSet
    public ResultSet executeQuery(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    // Execute a statement, return the number of rows affected
    public int executeUpdate(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }

    // Main method
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        try (Connection conn = handler.openConnection()) {
            String query = "SELECT * FROM Users WHERE UserName = ?";

            // Prepare the statement
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the parameter
            pstmt.setString(1, "admin");

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("UserName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}