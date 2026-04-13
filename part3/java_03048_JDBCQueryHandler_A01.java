import java.sql.*;

public class java_03048_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a Statement
            stmt = conn.createStatement();

            // Step 4: Execute a Query
            rs = stmt.executeQuery("SELECT * FROM users WHERE username = 'test' AND password = 'test'");

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                System.out.println("User Found: " + rs.getString("username") + " " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet and Statement
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}