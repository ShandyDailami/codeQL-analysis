import java.sql.*;

public class java_34703_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Prepare a statement
            stmt = conn.prepareStatement("SELECT * FROM Users WHERE id = ?");

            // Set the parameter value
            stmt.setInt(1, 123);

            // Execute the statement
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Clean up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}