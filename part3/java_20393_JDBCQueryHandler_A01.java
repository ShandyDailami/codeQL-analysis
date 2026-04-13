import java.sql.*;

public class java_20393_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // Your database URL
        String username = "root"; // Your username
        String password = "password"; // Your password

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}