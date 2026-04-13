import java.sql.*;

public class java_17676_JDBCQueryHandler_A01 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Connect to database
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role = 'admin'");

            // Print results
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("User Name: " + rs.getString("name"));
                System.out.println("User Email: " + rs.getString("email"));
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}