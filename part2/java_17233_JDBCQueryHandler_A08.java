import java.sql.*;

public class java_17233_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Please replace with your actual password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create a Statement object
            stmt = conn.createStatement();

            // Step 4: Execute a SQL Query
            String sql = "SELECT UserID, UserName, Email FROM Users WHERE UserID = '1'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("UserID: " + rs.getString("UserID"));
                System.out.println("UserName: " + rs.getString("UserName"));
                System.out.println("Email: " + rs.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the Statement and Connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}