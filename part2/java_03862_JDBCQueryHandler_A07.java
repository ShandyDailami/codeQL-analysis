import java.sql.*;

public class java_03862_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a Query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Users WHERE Name = 'John' AND Password = 'mypassword'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the Result
            while (rs.next()) {
                String name = rs.getString("Name");
                String password = rs.getString("Password");
                System.out.println("Name: " + name);
                System.out.println("Password: " + password);
            }

            // Step 5: Cleanup
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}