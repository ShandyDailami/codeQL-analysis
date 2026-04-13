import java.sql.*;

public class java_05044_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Set up the connection string (replace with your actual values)
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the query
            String sql = "SELECT * FROM Users WHERE password = 'somesalt'";
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Close the result set and statement
            rs.close();
            stmt.close();

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
}