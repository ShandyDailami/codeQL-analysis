import java.sql.*;

public class java_39966_JDBCQueryHandler_A08 {
    public static final String url = "jdbc:mysql://localhost:3306/testdb";
    public static final String username = "root";
    public static final String password = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            String sql = "SELECT * FROM Users WHERE Password='password'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String userName = rs.getString("UserName");
                String password = rs.getString("Password");

                System.out.println("UserName: " + userName);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the ResultSet and Statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}